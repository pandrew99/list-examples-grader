# Create your grading script here

set -e

CPATHTESTS=".:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar"

rm -rf student-submission
git clone $1 student-submission

if [ -f "./student-submission/ListExamples.java" ]
then
    cp TestListExamples.java ./student-submission
    cd ./student-submission
    set +e
    javac -cp $CPATHTESTS *.java
    if [ $? -eq 0 ]
    then
        java -cp $CPATHTESTS org.junit.runner.JUnitCore TestListExamples > output.txt
        if [ $? -eq 0 ]
        then
            echo "All tests passed"
        else
            echo "Some tests failed"
        fi
        t=$(grep -i "Tests run" output.txt)
        mails=$(echo $t | tr " " "\n")
        counter=0
        total=""
        passed=""
        for i in $mails
        do
            if [ $counter == 2 ]
            then
                total=${i%?}
            fi
            if [ $counter == 4 ]
            then
                passed=$i
            fi
            counter=$((counter+1))
        done
        echo You passed "$((total - passed))" / $total tests
        echo Your grade is "$((((total - passed)/total)*100))"%
    else
        echo "Compilation failed. Please check your code."
    fi
else
    echo "ListExamples does not exist"
    exit 1
fi