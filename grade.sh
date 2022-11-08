# Create your grading script here

set -e

# step 1
rm -rf student-submission
git clone $1 student-submission

# step 2
if find type -type f -name "ListExamples.java" -eq true
then echo "ListExamples.java file found!"
else echo "ListExamples.java file not found. Please check to make sure you submitted the right file"
exit

# step 3
cp TestListExamples.java student-submission/
cd student-submission/

# step 4
javac -cp .:lib/hamcrest-core-1.3.jar:lib/ijunit-4.13.2.jar *.java
if $? != 0
then
echo "Your code did not compile. Check to make sure you don't have any syntax errors."
fi

# step 5
java TestListExamples