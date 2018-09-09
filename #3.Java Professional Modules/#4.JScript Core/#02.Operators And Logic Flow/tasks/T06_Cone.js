function cone(a,b) {

    let radius = Number(a);
    let height = Number(b);

    let volume = 1 / 3 * (Math.PI * radius * radius * height);
    let slantHeight = Math.sqrt(radius * radius + height * height);
    let area = Math.PI * radius * (radius + slantHeight);

    console.log("volume =", volume);
    console.log("area = ", area);
}
cone(3,5);