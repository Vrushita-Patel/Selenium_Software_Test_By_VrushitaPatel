# Selenium Software Testing Project

This repository contains a comprehensive Selenium-based testing framework for e-commerce applications, specifically designed for testing Amazon-like platforms. The project demonstrates advanced Selenium automation techniques, robust test design patterns, and comprehensive test coverage.

## Project Structure

```
├── apache-maven-3.9.9/           # Maven build tool installation
├── selenium_training_repo/       # Git submodule with Selenium training materials
├── unified-ecommerce-tests/      # Main test suite (Maven project)
│   ├── pom.xml                   # Maven configuration
│   └── src/test/java/com/example/
│       ├── EcommerceTestSuite.java  # Main test suite class
│       └── PriceMonitor.java        # Price monitoring utility
├── run-tasks.bat                 # Windows batch script to run tests
├── run-tasks.sh                  # Unix shell script to run tests
├── run-unified-tests.bat         # Batch script for unified tests
├── pom.xml                       # Root Maven configuration
├── TODO.md                       # Project task tracking
└── TEST_REPORT.md                # Test execution reports
```

## Features

### ✅ Completed Features

- **Robust Product Selection**: Advanced algorithms to avoid sponsored ads and select genuine products
- **Search Filters**: Comprehensive price, rating, and brand filtering with verification
- **Error Handling**: Retry mechanisms and fallback strategies for unreliable web elements
- **Sponsored Product Detection**: Multiple detection methods (labels, text, attributes, CSS classes)
- **Cross-Platform Support**: Windows and Unix scripts for test execution
- **Maven Integration**: Full Maven build lifecycle with test reporting

### 🔧 Technical Stack

- **Java 8+**: Core programming language
- **Selenium WebDriver**: Browser automation framework
- **TestNG**: Testing framework for structured test execution
- **Maven**: Build automation and dependency management
- **ChromeDriver**: Chrome browser automation

## Prerequisites

- Java JDK 8 or higher
- Apache Maven 3.9.9 (included in repository)
- Chrome browser
- Git

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Vrushita-Patel/Selenium_Software_Test_By_VrushitaPatel.git
cd Selenium_Software_Test_By_VrushitaPatel
```

### 2. Initialize Submodules

```bash
git submodule update --init --recursive
```

### 3. Set Up Maven

The repository includes Apache Maven 3.9.9. Add it to your PATH or use the included scripts.

**Windows:**

```bash
set PATH=%PATH%;%cd%\apache-maven-3.9.9\bin
```

**Unix/Linux:**

```bash
export PATH=$PATH:$(pwd)/apache-maven-3.9.9/bin
```

### 4. Install Dependencies

```bash
mvn clean install
```

## Running Tests

### Option 1: Using Maven

```bash
cd unified-ecommerce-tests
mvn test
```

### Option 2: Using Provided Scripts

**Windows:**

```bash
run-unified-tests.bat
```

**Unix/Linux:**

```bash
chmod +x run-tasks.sh
./run-tasks.sh
```

### Option 3: Direct Java Execution

```bash
cd unified-ecommerce-tests
mvn compile
java -cp target/classes:$(mvn dependency:build-classpath | grep -v '\[') org.testng.TestNG src/test/resources/testng.xml
```

## Test Suite Overview

### EcommerceTestSuite.java

Main test class containing:

- **testCompleteEcommerceFlow()**: End-to-end shopping flow test
- **testSearchFilters()**: Search and filter functionality tests
- **testPriceMonitoring()**: Price tracking and alerts

### Key Test Features

- **Dynamic Element Handling**: Robust locators with multiple fallback strategies
- **Anti-Detection Measures**: Randomized delays and human-like interactions
- **Comprehensive Assertions**: Price, rating, and brand verification
- **Screenshot Capture**: Automatic screenshots on test failures
- **Detailed Logging**: Extensive logging for debugging and monitoring

## Configuration

### Browser Configuration

Tests are configured to run on Chrome by default. To modify:

1. Update `WebDriverManager.chromedriver().setup()` in test classes
2. Or set system property: `-Dwebdriver.chrome.driver=/path/to/chromedriver`

### Test Parameters

Key configurable parameters in `EcommerceTestSuite.java`:

- `SEARCH_QUERY`: Default search term ("laptop")
- `MAX_WAIT_TIME`: Element wait timeout (10 seconds)
- `RETRY_ATTEMPTS`: Number of retry attempts (3)

## Test Reports

Test execution reports are generated in:

- `unified-ecommerce-tests/target/surefire-reports/`: TestNG HTML reports
- `TEST_REPORT.md`: Custom test summary report

## Troubleshooting

### Common Issues

1. **ChromeDriver Version Mismatch**

   - WebDriverManager automatically handles driver versions
   - Manual update: Download latest ChromeDriver from https://chromedriver.chromium.org/

2. **Maven Build Failures**

   - Ensure Java JDK is properly installed
   - Check Maven version: `mvn -v`

3. **Test Timeouts**

   - Increase `MAX_WAIT_TIME` in test classes
   - Check internet connection stability

4. **Sponsored Ad Interference**
   - Tests include multiple detection and avoidance strategies
   - If issues persist, update selectors in `selectNonSponsoredProduct()`

## Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature-name`
3. Commit changes: `git commit -am 'Add feature'`
4. Push to branch: `git push origin feature-name`
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

**Vrushita Patel**

- GitHub: [@Vrushita-Patel](https://github.com/Vrushita-Patel)
- Repository: [Selenium_Software_Test_By_VrushitaPatel](https://github.com/Vrushita-Patel/Selenium_Software_Test_By_VrushitaPatel)

## Acknowledgments

- Selenium WebDriver documentation
- TestNG framework
- Maven build tool
- ChromeDriver team
