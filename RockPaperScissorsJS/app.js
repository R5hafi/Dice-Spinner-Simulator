let uScore = 0;
let cScore = 0;
const uScoreSpan = document.getElementById("user-score");
const cScoreSpan = document.getElementById("computer-score");
const scoreBoardDiv = document.querySelector(".score-board");
const resultP = document.querySelector(".result > p");
const rockDiv = document.getElementById("r");
const paperDiv = document.getElementById("p");
const scissorsDiv = document.getElementById("s");

function getComputerChoice(u, c) {
    const choices = ['r','p','s'];
    const randomNumber = (Math.floor(Math.random()*3));
    return choices[randomNumber];
}

function convertToWord(letter){
    if(letter === "r") return "Rock";
    if(letter === "p") return "Paper";
    return "Scissors";
}

function win(uChoice, cChoice){
    uScore++;
    uScoreSpan.innerHTML=uScore;
    cScoreSpan.innerHTML=cScore;
    const smallUserWord = "user".fontsize(3).sub();
    const smallCompWord = "comp".fontsize(3).sub();
    resultP.innerHTML= `${convertToWord(uChoice)}${smallUserWord} beats ${convertToWord(cChoice)}${smallCompWord}. You win!`
    //convertToWord(uChoice)+" beat "+convertToWord(cChoice)+". You win!" is equivalent to above
}

function lose(uChoice, cChoice){
    cScore++;
    uScoreSpan.innerHTML=uScore;
    cScoreSpan.innerHTML=cScore;
    const smallUserWord = "user".fontsize(3).sub();
    const smallCompWord = "comp".fontsize(3).sub();
    resultP.innerHTML= `${convertToWord(uChoice)}${smallUserWord} loses to ${convertToWord(cChoice)}${smallCompWord}. You lost...`
}

function draw(uChoice, cChoice){
    const smallUserWord = "user".fontsize(3).sub();
    const smallCompWord = "comp".fontsize(3).sub();
    resultP.innerHTML= `${convertToWord(uChoice)}${smallUserWord} equals ${convertToWord(cChoice)}${smallCompWord}. It's a draw.`
}

function game(uChoice){
    const cChoice = getComputerChoice();
    if(uChoice+cChoice==="rs"||uChoice+cChoice==="pr"||uChoice+cChoice==="sp"){
        win(uChoice, cChoice);
    } else if (uChoice+cChoice==="rp"||uChoice+cChoice==="ps"||uChoice+cChoice==="sr"){
        lose(uChoice, cChoice);
    } else {
        draw(uChoice, cChoice);
    }
}

function main(){
    rockDiv.addEventListener('click', function(){
        game("r");
    })
    
    //arrow symbol does the same as above rockDiv
    paperDiv.addEventListener('click', () => game("p"));
    
    scissorsDiv.addEventListener('click', function(){
        game("s");
    })
}

main();

//tutorial reference: https://www.youtube.com/watch?v=jaVNP3nIAv0