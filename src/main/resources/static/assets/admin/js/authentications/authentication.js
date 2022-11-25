"use strict";

const passwordToggleEventHandler = (selectorHide, selectorShow, selectorTarget) => {
    const $ = (selector) => document.querySelector(selector);
    const getSelectorHide = $(selectorHide);
    const getSelectorShow = $(selectorShow);
    const getSelectorTarget = $(selectorTarget);

    getSelectorHide.addEventListener("click", () => {
        getSelectorTarget.setAttribute("type", getSelectorTarget.getAttribute("type") === "password" ? "text" : "password");
        getSelectorHide.classList.add("hidden");
        getSelectorShow.classList.remove("hidden");

        passwordToggleEventHandler(selectorShow, selectorHide, selectorTarget);
    });
}

passwordToggleEventHandler("#icon-eye", "#icon-eye-slash", "#password");