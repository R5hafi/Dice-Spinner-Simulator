let host = 100;
let player = 50;
let dice = Math.floor((Math.random() * 8) + 1);
let spinner = Math.floor((Math.random() * 4) + 1);
let total = dice + spinner;
let roundNum = 0;
document.querySelector('.dice1').style.display = "none";
document.querySelector('.dice2').style.display = "none";
document.querySelector('.dice3').style.display = "none";
document.querySelector('.dice4').style.display = "none";
document.querySelector('.dice5').style.display = "none";
document.querySelector('.dice6').style.display = "none";
document.querySelector('.dice7').style.display = "none";
document.querySelector('.dice8').style.display = "none";

document.querySelector('.spinner1').style.display = "none";
document.querySelector('.spinner2').style.display = "none";
document.querySelector('.spinner3').style.display = "none";
document.querySelector('.spinner4').style.display = "none";

document.getElementById("btn").addEventListener("click", function(){
"use strict";
dice = Math.floor((Math.random() * 8) + 1);
spinner = Math.floor((Math.random() * 4) + 1);
total = dice + spinner;
roundNum = roundNum + 1;

//total sum case
switch (total) {
		case 2:
    host = host - 20;
		player = player + 20;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = 'green';
    break;
		case 3:
    host = host;
		player = player;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = "white";
    break;
		case 4:
    host = host;
		player = player;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = "white";
    break;
		case 5:
    host = host + 5;
		player = player - 5;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = 'red';
    break;
		case 6:
    host = host + 5;
		player = player - 5;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = 'red';
    break;
		case 7:
    host = host + 5;
		player = player - 5;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = 'red';
    break;
		case 8:
    host = host + 5;
		player = player - 5;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = 'red';
    break;
		case 9:
    host = host + 5;
		player = player - 5;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = 'red';
    break;
  	case 10:
    host = host;
		player = player;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = "white";
    break;
		case 11:
    host = host;
		player = player;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = "white";
    break;
  	case 12:
    host = host - 20;
		player = player + 20;
		document.querySelector(".hostMoney").innerText = "Host: $"+host;
		document.querySelector(".playerMoney").innerText = "Player: $"+player;
		document.querySelector(".playerMoney").style.color = 'green';
    break;
    default:
}

//dice case
		switch (dice) {
				case 1:
				document.querySelector('.dice1').style.display = "block";
				document.querySelector('.dice2').style.display = "none";
				document.querySelector('.dice3').style.display = "none";
				document.querySelector('.dice4').style.display = "none";
				document.querySelector('.dice5').style.display = "none";
				document.querySelector('.dice6').style.display = "none";
				document.querySelector('.dice7').style.display = "none";
				document.querySelector('.dice8').style.display = "none";
				break;
				case 2:
				document.querySelector('.dice1').style.display = "none";
				document.querySelector('.dice2').style.display = "block";
				document.querySelector('.dice3').style.display = "none";
				document.querySelector('.dice4').style.display = "none";
				document.querySelector('.dice5').style.display = "none";
				document.querySelector('.dice6').style.display = "none";
				document.querySelector('.dice7').style.display = "none";
				document.querySelector('.dice8').style.display = "none";
				break;
				case 3:
				document.querySelector('.dice1').style.display = "none";
				document.querySelector('.dice2').style.display = "none";
				document.querySelector('.dice3').style.display = "block";
				document.querySelector('.dice4').style.display = "none";
				document.querySelector('.dice5').style.display = "none";
				document.querySelector('.dice6').style.display = "none";
				document.querySelector('.dice7').style.display = "none";
				document.querySelector('.dice8').style.display = "none";
				break;
				case 4:
				document.querySelector('.dice1').style.display = "none";
				document.querySelector('.dice2').style.display = "none";
				document.querySelector('.dice3').style.display = "none";
				document.querySelector('.dice4').style.display = "block";
				document.querySelector('.dice5').style.display = "none";
				document.querySelector('.dice6').style.display = "none";
				document.querySelector('.dice7').style.display = "none";
				document.querySelector('.dice8').style.display = "none";
				break;
				case 5:
				document.querySelector('.dice1').style.display = "none";
				document.querySelector('.dice2').style.display = "none";
				document.querySelector('.dice3').style.display = "none";
				document.querySelector('.dice4').style.display = "none";
				document.querySelector('.dice5').style.display = "block";
				document.querySelector('.dice6').style.display = "none";
				document.querySelector('.dice7').style.display = "none";
				document.querySelector('.dice8').style.display = "none";
				break;
				case 6:
				document.querySelector('.dice1').style.display = "none";
				document.querySelector('.dice2').style.display = "none";
				document.querySelector('.dice3').style.display = "none";
				document.querySelector('.dice4').style.display = "none";
				document.querySelector('.dice5').style.display = "none";
				document.querySelector('.dice6').style.display = "block";
				document.querySelector('.dice7').style.display = "none";
				document.querySelector('.dice8').style.display = "none";
				break;
				case 7:
				document.querySelector('.dice1').style.display = "none";
				document.querySelector('.dice2').style.display = "none";
				document.querySelector('.dice3').style.display = "none";
				document.querySelector('.dice4').style.display = "none";
				document.querySelector('.dice5').style.display = "none";
				document.querySelector('.dice6').style.display = "none";
				document.querySelector('.dice7').style.display = "block";
				document.querySelector('.dice8').style.display = "none";
				break;
				case 8:
				document.querySelector('.dice1').style.display = "none"; 
				document.querySelector('.dice2').style.display = "none";
				document.querySelector('.dice3').style.display = "none";
				document.querySelector('.dice4').style.display = "none";
				document.querySelector('.dice5').style.display = "none";
				document.querySelector('.dice6').style.display = "none";
				document.querySelector('.dice7').style.display = "none";
				document.querySelector('.dice8').style.display = "block";
				break;
				default:
		}

//spinner case
switch (spinner) {
		case 1:
		document.querySelector('.spinner1').style.display = "block";
		document.querySelector('.spinner2').style.display = "none";
		document.querySelector('.spinner3').style.display = "none";
		document.querySelector('.spinner4').style.display = "none";
    break;
		case 2:
    document.querySelector('.spinner1').style.display = "none";
		document.querySelector('.spinner2').style.display = "block";
		document.querySelector('.spinner3').style.display = "none";
		document.querySelector('.spinner4').style.display = "none";
    break;
		case 3:
    document.querySelector('.spinner1').style.display = "none";
		document.querySelector('.spinner2').style.display = "none";
		document.querySelector('.spinner3').style.display = "block";
		document.querySelector('.spinner4').style.display = "none";
    break;
		case 4:
		document.querySelector('.spinner1').style.display = "none";
		document.querySelector('.spinner2').style.display = "none";
		document.querySelector('.spinner3').style.display = "none";
		document.querySelector('.spinner4').style.display = "block";
    default:
}

document.querySelector(".round").innerText = "Round: "+roundNum;
document.querySelector(".diceRes").innerText = "8-Sided Dice: "+dice;
document.querySelector(".spinnerRes").innerText = "Spinner: "+spinner;
document.querySelector(".totalSum").innerText = "Total Sum: "+total;
});


