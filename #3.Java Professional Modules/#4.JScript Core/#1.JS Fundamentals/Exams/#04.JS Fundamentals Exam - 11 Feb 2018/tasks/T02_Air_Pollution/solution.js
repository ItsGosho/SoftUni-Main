//Gosho exam:
function f(map, commands) {
    let matrix = [[]];
    for (let i = 0; i < map.length; i++) {
        matrix[i] = new Array(5);
        let splitted = map[i].split(/ /);
        for (let j = 0; j < splitted.length; j++) {
            matrix[i][j] = parseInt(splitted[j]);
        }
    }
    let commands2 = commands;
    for (let i = 0; i < commands2.length; i++) {
        let splitted = commands2[i].split(/ /);
        let command = splitted[0];
        let number = parseInt(splitted[1]);
        switch (command) {
            case "breeze":
                for (let j = number; j < number + 1; j++) {
                    for (let k = 0; k < matrix[j].length; k++) {
                        matrix[j][k] -= 15;
                    }
                }

                break;
            case "gale":
                for (let j = number; j < number + 1; j++) {
                    for (let k = 0; k < matrix.length; k++) {
                        matrix[k][j] -= 20;
                    }
                }

                break;
            case "smog":
                for (let j = 0; j < matrix.length; j++) {
                    for (let k = 0; k < matrix[j].length; k++) {
                        matrix[j][k] += number;
                    }
                }

                break;
        }
    }
    let arrStoinsti = [];
    for (let j = 0; j < matrix.length; j++) {
        for (let k = 0; k < matrix[j].length; k++) {
            if (matrix[j][k] >= 50) {
                arrStoinsti.push("[" + j + "-" + k + "]");
            }
        }
    }
    if (arrStoinsti.length >= 1) {
        console.log("Polluted areas: " + arrStoinsti.join(", "));
    } else {
        console.log("No polluted areas");
    }
}

f([
        "5 7 2 14 4",
        "21 14 2 5 3",
        "3 16 7 42 12",
        "2 20 8 39 14",
        "7 34 1 10 24",
    ],
    ["breeze 1", "gale 2", "smog 35"]

);