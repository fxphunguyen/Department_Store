"use strict";

class Employee {
    constructor(email, password) {
        this.email = email;
        this.password = password;
    }
}

class AuthenticationLogin {
    constructor(email, password) {
        this.email = email;
        this.password = password;
    }
}

const saveLoginDataToLocalStorage = (data) => window.localStorage.setItem("login_data", JSON.stringify(data));

const loginEventHandler = () => {
    try {
        const getLoginInputValue = {
            "email": $("#login-email").val(),
            "password": $("#login-password").val()
        }

        $.ajax({
            "headers": {
                "accept": "application/json",
                "content-type": "application/json"
            },

            "url": "http://localhost:8080/api/authentication/login",
            "data": JSON.stringify(getLoginInputValue),
            "type": "post"
        })
        .done((data) => {
            saveLoginDataToLocalStorage(data);
            alert("Bạn đã đăng nhập vào hệ thống thành công!");
            window.location.href = "/admin/home";
        })
        .fail((error) => console.log("Login failed: " + error));

    } catch (error) {
        throw new Error("An error occurred: " + error);
    }
}

$("#login-submit").on("click", () => loginEventHandler());

