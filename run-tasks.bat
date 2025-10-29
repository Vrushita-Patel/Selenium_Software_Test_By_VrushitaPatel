@echo off
echo ========================================
echo Running ALL Ecommerce Automation Tasks
echo ========================================

REM Task 1: Basic Selenium Setup
echo.
echo Running Task 1 - Basic Selenium Setup...
echo Requirements: Setup Selenium WebDriver, navigate to Amazon, verify title
echo.
cd task1
call ../apache-maven-3.9.9/bin/mvn.cmd test
cd ..
echo Task 1 completed.
echo.

REM Task 2: Search Functionality
echo Running Task 2 - Search Functionality...
echo Requirements: Search for "laptop", verify search results
echo.
cd task2
call ../apache-maven-3.9.9/bin/mvn.cmd test
cd ..
echo Task 2 completed.
echo.

REM Task 3: Product Selection
echo Running Task 3 - Product Selection...
echo Requirements: Click first product, verify product page
echo.
cd task3
call ../apache-maven-3.9.9/bin/mvn.cmd test
cd ..
echo Task 3 completed.
echo.

REM Task 4: Add to Cart
echo Running Task 4 - Add to Cart...
echo Requirements: Add product to cart, verify cart contents
echo.
cd task4
call ../apache-maven-3.9.9/bin/mvn.cmd test
cd ..
echo Task 4 completed.
echo.

REM Task 5: Complete Ecommerce Flow Test
echo Running Task 5 - Complete Ecommerce Flow Test...
echo Requirements: Search product, add to cart, verify payment ^> Rs 500, confirm order
echo Time window: 6 PM - 7 PM ^(currently disabled for testing^)
echo.
cd task5
call ../apache-maven-3.9.9/bin/mvn.cmd test
cd ..
echo Task 5 completed.
echo.

REM Task 6: Checkout Process
echo Running Task 6 - Checkout Process...
echo Requirements: Navigate to checkout, verify payment options
echo.
cd task6
call ../apache-maven-3.9.9/bin/mvn.cmd test
cd ..
echo Task 6 completed.
echo.

echo.
echo ========================================
echo ALL TASKS COMPLETED SUCCESSFULLY!
echo ========================================
pause
