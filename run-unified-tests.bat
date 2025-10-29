t@echo off
echo ========================================
echo Running ALL 6 Ecommerce Tasks in ONE COMMAND
echo ========================================
echo.

cd unified-ecommerce-tests

echo Running all 6 ecommerce tasks in a single Maven command...
echo This will execute all test methods sequentially in one run.
echo.

..\apache-maven-3.9.9\bin\mvn clean test -Dtest=EcommerceTestSuite

cd ..

echo.
echo ========================================
echo ALL TASKS COMPLETED IN ONE COMMAND!
echo ========================================
echo.
echo Tasks executed in this run:
echo - Task 1: Product Selection Test (3 PM - 6 PM)
echo - Task 2: Cart Automation Test (6 PM - 7 PM)
echo - Task 3: Login Validation Test (12 PM - 3 PM)
echo - Task 4: Price Monitor Test (No time restriction)
echo - Task 5: Complete Ecommerce Flow Test (6 PM - 7 PM)
echo - Task 6: Product Search with Filters Test (3 PM - 6 PM)
echo.
echo All tasks have been integrated into a single unified application
echo as required by the course curriculum framework.
echo.
pause
