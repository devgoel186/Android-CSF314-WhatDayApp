# WhatDay

This simple Android app asks the user for a date in the Gregorian calendar and returns the day of the week for that date.

### a. Basic Information

**Name of the Project** - What Day App

**Name of Student** - Dev Goel

**BITS ID** - 2019A7PS0236G

**Email** - f20190236@goa.bits-pilani.ac.in

### b. What does the app do? Any known bugs?

The What Day App takes a date, month and year as input from the user as an input and reports the day of the week for that particular date.
The app currently has no known bugs.

### c. Description of completed tasks and steps followed to achieve them

**Task 1 - Developing DateModel**

* The DateModel has the `initialize()` function that initializes the year, month and date with values given by user.
* Implemented checks for improper input data format by writing the private function `isParsable()`. This checks the input string and returns whether it can be parsed to an integer or not.
* Wrote the private function `checkAndAssignMessage()` which checks valid dates, months and year, and leap years. If any input is invalid, the function returns false. This function also assigns an appropriate message as per the requirements of the assignment.
* The function `getMessage()` simply returns the message.

**Task 2 - Modifying the UI**

* I store the views of each input / display field under named variables in the **MainActivity.java** file.
* Calling the `initialize()` function, I initialized the DateModel with user provided input.
* Calling the `getMessage()` function, the DateModel returns the appropriate message for the input.
* This message is then set as text in the **txt_display** TextView element to show to the user.

**ADDITIONAL FEATURE** - Added some horizontal padding for the day display field, as the previous UI made the text appear a bit cramped.

**Task 3 - Accessibility**

* I ran the application using **TalkBack** service. The service is fairly easy to use and guides the user on each and every step. All input elements were recognized by TalkBack as input boxes, and the hint text present by default in these elements was read aloud. Tapping once on the displayed result read aloud the text to the user. I could easily understand where my finger was on the screen and which element was active. Overall, TalkBack is a great accessibility tool which can help blind people or people with vision impairments to use apps.

* I ran **Accessibility Scanner** on the application, which reported the following two issues:
 * Small touch target size - The touch target size of the input elements was 45dp. This was increased to 48dp to meet accessibility standards.
 * Text contrast - Foreground to background contrast ratio was not correct. This was fixed by making changes in **activity_main.xml** file.

* I also set the `android:contentDescription` property for the **check** button.

### d. Testing using written test cases and monkey stress-testing

* I followed a test-driven approach for this assignment, writing and running test cases as I worked on the edge cases for the code.
* I wrote instrumented tests and ran all tests after each step I completed in the assignment, while adding new test cases.
* In total I wrote 14 Instrumented test cases and 3 DateModelTests excluding the 2 given Instrumented tests and 6 given DateModel tests.
* I ran both the DateModelTests and InstrumentedTests successfully on the app.
* For monkey stress testing, I ran the monkey tool for 5000 iterations using the command `adb shell monkey -p androidsamples.java.whatday -v 5000`.

Running tests on my app after each step helped me get a more detailed idea as to how the app was functioning, and also helped me figure out some corner cases which I corrected to avoid app crashes.
I ran the monkey tool successfully for 1500, 2500 and 5000 iterations. The app did not crash on any run.

### e. Approximate number of hours it took to complete the assignment

**Writing Code, Testing and Solving Accessibility Issues** -> 4 hours

**Documentation** -> 1 hour

**Total Time = 5 hours**

### f. Difficulty of Assignment

On a scale of 1 to 10, I would rate the difficulty of the assignment as **5**.

I feel the assignment was not very difficult in terms of logic to be used, but the integral part was testing and accessibility.
I spent more time testing and fixing corner cases as compared to coding the logic. This helped me get a better idea of the limitations of the app, and how I can remove these limits.