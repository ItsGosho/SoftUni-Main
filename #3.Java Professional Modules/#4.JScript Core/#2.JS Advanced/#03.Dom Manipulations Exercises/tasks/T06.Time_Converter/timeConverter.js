function attachEventsListeners() {
    let buttonDay = document.getElementById("daysBtn");
    let inputDay = document.getElementById("days");
    let buttonHours = document.getElementById("hoursBtn");
    let inputHours = document.getElementById("hours");
    let buttonMinutes = document.getElementById("minutesBtn");
    let inputMinutes = document.getElementById("minutes");
    let buttonSeconds = document.getElementById("secondsBtn");
    let inputSeconds = document.getElementById("seconds");

    buttonDay.addEventListener("click",function () {
         inputHours.value=inputDay.value*24;
         inputMinutes.value=inputHours.value*60;
         inputSeconds.value=inputMinutes.value*60;
    });

    buttonHours.addEventListener("click",function () {
        inputDay.value=inputHours.value/24;
        inputMinutes.value=inputHours.value*60;
        inputSeconds.value=inputMinutes.value*60;
    });

    buttonMinutes.addEventListener("click",function () {
        inputHours.value=inputMinutes.value/60;
        inputDay.value=inputHours.value/24;
        inputSeconds.value=inputMinutes.value*60;
    });

    buttonSeconds.addEventListener("click",function () {
        inputMinutes.value=inputSeconds.value/60;
        inputHours.value=inputMinutes.value/60;
        inputDay.value=inputHours.value/24;
    });
}
