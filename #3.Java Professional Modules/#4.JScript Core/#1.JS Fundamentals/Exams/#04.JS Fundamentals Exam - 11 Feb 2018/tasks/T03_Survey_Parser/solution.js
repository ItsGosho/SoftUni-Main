//Gosho exam:
function f(words){
    let overMatche=RegExp(/^(.+)?(<svg>[ ]{0,})(<cat>)([ ]{0,})(<text>)([ ]{0,})(.+)(\[)(.+)(\])(<\/text>)([ ]{0,})(<\/cat>)([ ]{0,})(<cat>[ ]{0,})(.+)(<\/cat>)[ ]{0,}(<\/svg>)(.+)?$/);

    //group 2
    let text="";
    for (let i = 0; i < words.length; i++) {
        text+=words[i];
    }
    let svgMatcher=RegExp(/(<svg>)(.+)(<\/svg>)/);
    let labelMatcher=RegExp(/(<cat><text>)(.+)(\[(.+)\])(<\/text><\/cat>)(<cat>)(.+)(<\/cat>)/);
    let svgMatch=svgMatcher.exec(text);
    if(svgMatch){
        let overallMatch=overMatche.exec(text);
        if(overallMatch){
            let label=overallMatch[9];
            let nextText2=overallMatch[16];
            let valueMatcher=RegExp(/^(<g>)(<val>)(\d+)(<\/val>)(\d+)$/);
            let test=nextText2.split(/<\/g>/).filter(x=>x!=="");

            let error=false;
            let koch=0;
            let count=0;
            for (let i = 0; i < test.length; i++) {
                let matchResult=valueMatcher.exec(test[i]);
                if(matchResult){
                    if(parseInt(matchResult[3])>=1 && parseInt(matchResult[3])<=10){
                        koch+=parseInt(matchResult[3])*parseInt(matchResult[5]);
                        if(parseInt(matchResult[3])!==0){
                            count+=parseInt(matchResult[5]);
                        }else{
                            count+=1;
                        }
                    }else{
                        error=true;
                    }
                }else{
                    error=true;
                    break;
                }
            }
            if(error){
                console.log("Invalid format");
            }else{
                koch/=count;
                console.log(label+": "+koch.toFixed(2).replace(/\.?0+$/, ''));
            }

        }else{
            console.log("Invalid format");
        }
    }else{
        console.log("No survey found");
    }
}

f("<p>Some random text</p><svg><cat><text>How do you rate our food? [Food - General]</text></cat> <cat><g><val>1</val>0</g><g><val>2</val>0</g><g><val>3</val>3</g><g><val>4</val>10</g><g><val>5</val>7</g></cat></svg><p>Some more random text</p>");