function attachGradientEvents() {
    let element = document.getElementById("gradient-box");
    let result=document.getElementById("result");
    element.addEventListener("mousemove", move);
    element.addEventListener("mouseout", out);

    function move(event) {

        result.textContent = Math.floor((event.offsetX/300)*100)+"%";
    }

    function out() {
        result.textContent="";
    }
}