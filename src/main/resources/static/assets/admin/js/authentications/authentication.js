"use strict";

const passwordToggleEventHandler = async (selectorInput, selectorShow, selectorHide) => {
    try {
        const $ = async (selector) => await document.querySelector(selector);

        const getSelectorInput = await $(selectorInput);
        const getSelectorShow = await $(selectorShow);
        const getSelectorHide = await $(selectorHide);

        await getSelectorShow.addEventListener("click", async () => {
            await getSelectorInput.setAttribute("type", getSelectorInput.getAttribute("type") === "password" ? "text" : "password");
            await getSelectorShow.classList.add("hidden");
            await getSelectorHide.classList.remove("hidden");
        });

    } catch (exception) {
        console.log("An exception occurred: " + exception);
    }
}

const passwordToggleEventIntermediary = async (selectorInput, selectorShow, selectorHide) => {
    try {
        await passwordToggleEventHandler(selectorInput, selectorShow, selectorHide);
        await passwordToggleEventHandler(selectorInput, selectorHide, selectorShow);

    } catch (exception) {
        console.log("An exception occurred: " + exception);
    }
}

await passwordToggleEventIntermediary("#login-password", "#login-icon-eye-id", "#login-icon-eye-slash-id");