<div align="center">
 <img  src="https://user-images.githubusercontent.com/68038931/147390936-c6228337-9787-4aab-b5d6-826bc8e4e4a3.gif" alt="test-light" width="1000" height="250" />
 </div>

 <div align="center">
      <h1> API Automation Testing With Cucumber Framework </h1>

## 📌 Features
- ### 🔍️ Covered Test case in this project :
#### ✅Test Case 1 : Create a new post
   Given the API is available
    When I create a post with title "foo", body "bar" and userId 1
    Then the response status should be 201
    And the response should contain title "foo" and body "bar"

#### ✅Test Case 2 : Get all posts
   Given the API is available
    When I retrieve all posts
    Then the response status should be 200
    And the total number of posts should be 100

#### ✅Test Case 3 : Get post with ID 20
   Given the API is available
    When I retrieve the post with ID 20
    Then the response status should be 200
    And the response should contain ID 20

 #### ✅Test Case 4 : Get non-existent post
   Given the API is available
    When I retrieve the post with ID 20
    Then the response status should be 200
    And the response should contain ID 20



## 🛠 Tech Stack

- Java
- Cucumber
- Rest Assured
- Maven
- JUnit/TestNG (depending on your setup)
- JSON for request/response payloads

## 📂 Project Structure

![Image](https://github.com/user-attachments/assets/24e97b90-8726-41db-beac-1759bdd73271)


 ### 🏗️ Project Design:

 * Page Object Model (POM) design pattern

### 🚧 Requirements

* Eclipse / IntelliJ IDEA (for code development)

 ### 📝 Allure Report:

![allureReport](https://github.com/user-attachments/assets/8132c19a-18b3-416d-ab91-60f230dbe6da)

 ### 📝 Cucumber Report:
 
 ![Image](https://github.com/user-attachments/assets/b6e1ef5c-309b-4883-98f3-a8615504c4da)

 ### 🚀 For Watching Running Test Cases:
 
   https://youtu.be/FvKjAGaXQBQ

