# Performance_Test

# Apache JMeter Menu Guide

## Introduction
Apache JMeter is a powerful open-source tool used for performance and load testing of applications. This document provides a detailed overview of JMeter's menu options along with examples to help users understand their functions and usage.

## Table of Contents
- [File Menu](#file-menu)
- [Edit Menu](#edit-menu)
- [Search Menu](#search-menu)
- [Run Menu](#run-menu)
- [Options Menu](#options-menu)
- [Tools Menu](#tools-menu)
- [Help Menu](#help-menu)
- [Right-Click "Add" Menu](#right-click-add-menu)

---

## File Menu
**Purpose:** Handles test plan files, saving, and loading.

| Option | Description | Example |
|--------|------------|---------|
| New | Creates a new Test Plan | Start fresh with a new test configuration |
| Open | Opens an existing Test Plan | Load a `.jmx` file with predefined test cases |
| Save | Saves the current Test Plan | Save all configurations in a `.jmx` file |
| Save As | Saves the test plan with a different name | Save a modified test as `performance_test_v2.jmx` |
| Revert | Discards unsaved changes and reloads the last saved version | Undo unintended modifications |
| Exit | Closes JMeter | End the session |

---

## Edit Menu
**Purpose:** Allows undo/redo actions, copying components, and enabling/disabling test elements.

| Option | Description | Example |
|--------|------------|---------|
| Undo | Reverts the last action | Undo accidental deletion of a thread group |
| Redo | Reapplies the last undone action | Redo an action that was mistakenly undone |
| Cut | Removes and copies selected elements | Move a test case from one test plan to another |
| Copy | Duplicates selected elements | Copy an HTTP request sampler for another scenario |
| Paste | Inserts copied elements | Add a copied assertion to another sampler |
| Delete | Removes selected elements | Delete an unnecessary transaction controller |
| Enable/Disable | Activates or deactivates elements without deleting them | Temporarily disable a loop controller |

---

## Search Menu
**Purpose:** Helps locate specific test plan elements.

| Option | Description | Example |
|--------|------------|---------|
| Search | Finds elements by name or property | Locate all occurrences of `Login API` in the test plan |
| Search & Replace | Replaces text in test elements | Replace `staging.example.com` with `prod.example.com` |

---

## Run Menu
**Purpose:** Controls test execution.

| Option | Description | Example |
|--------|------------|---------|
| Start | Begins the test execution | Run a load test with 500 virtual users |
| Start No Pause | Runs the test without pauses | Execute the test ignoring debug timers |
| Stop | Gracefully stops the test | End the test and generate reports |
| Shutdown | Forcibly stops the test | Abort a test due to server overload |
| Restart | Restarts JMeter | Refresh the session and reload the test plan |
| Clear All | Clears all test results | Reset results before a new test run |

---

## Options Menu
**Purpose:** Configures JMeter preferences.

| Option | Description | Example |
|--------|------------|---------|
| Log Viewer | Displays logs for debugging | View error messages in HTTP request failures |
| Choose Language | Sets the JMeter UI language | Switch to French or Spanish |
| Look and Feel | Changes the UI theme | Set theme to `Dark Mode` |

---

## Tools Menu
**Purpose:** Provides additional utilities.

| Option | Description | Example |
|--------|------------|---------|
| Generate Report Dashboard | Creates a performance report | Convert `.jtl` results into an HTML report |
| Plugins Manager | Installs additional plugins | Add `Custom Thread Group` and `Throughput Shaping Timer` |

---

## Help Menu
**Purpose:** Provides documentation and support.

| Option | Description | Example |
|--------|------------|---------|
| Help Contents | Opens JMeter documentation | Learn how to configure a JDBC request |
| About JMeter | Displays version details | Check if JMeter is updated |

---

## Right-Click "Add" Menu
**Purpose:** Adds elements to the test plan.

### Thread (Users)
Used to define virtual users for the test.
- **Thread Group** – Creates multiple users and controls execution (e.g., 50 users ramping up over 10 seconds).
- **SetUp/TearDown Thread Group** – Executes setup/cleanup actions before/after the test.

### Logic Controllers
Control the execution flow of samplers.
- **Loop Controller** – Repeats requests (e.g., Run login 5 times before logout).
- **If Controller** – Runs elements conditionally (e.g., Execute API request only if status is `success`).

### Samplers
Generate requests to the server.
- **HTTP Request** – Simulates web requests (e.g., Send a POST request to `https://api.example.com/login`).
- **JDBC Request** – Runs SQL queries (e.g., `SELECT * FROM users`).

### Config Elements
Modify requests dynamically.
- **CSV Data Set Config** – Reads input from a CSV file (e.g., Load multiple login credentials).
- **HTTP Header Manager** – Adds headers to requests (e.g., Set `Authorization: Bearer <token>`).

### Timers
Introduces delays between requests.
- **Constant Timer** – Adds a fixed wait time (e.g., Wait 2 seconds between requests).
- **Uniform Random Timer** – Adds a random delay (e.g., Wait between 1 to 3 seconds randomly).

### Assertions
Validates test responses.
- **Response Assertion** – Checks if responses contain expected data (e.g., Verify `status: 200`).
- **Duration Assertion** – Fails if response time exceeds a limit (e.g., Ensure API responds within 2 seconds).

### Postprocessors
Extracts data from responses.
- **JSON Extractor** – Extracts values from JSON (e.g., Retrieve `access_token` from API response).
- **Regular Expression Extractor** – Extracts values using regex (e.g., Extract session ID from a response).

### Listeners
Records test results for analysis.
- **View Results Tree** – Displays request/response logs (e.g., Debug HTTP response failures).
- **Summary Report** – Shows performance metrics (e.g., Average response time, error rate, throughput).

---

## Conclusion
This guide provides a structured overview of JMeter’s menus and their functions. By understanding each menu option, users can efficiently design, execute, and analyze performance tests.

Would you like a step-by-step example test plan added? Let us know! 🚀

