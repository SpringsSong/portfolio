"use strict";

// get 3 scores from user and add them together
const score1 = parseInt(prompt("Enter test score"));

const score2 = parseInt(prompt("Enter test score"));

const score3 = parseInt(prompt("Enter test score"));

//adding in the requested 4th score
const score4 = parseInt(prompt("Enter test score"));

//formula updated to account for fourth score
const total = score1 + score2 + score3 + score4;

// calculate the average, updated to account for additional score
const average = parseInt(total/4);

// display in browser page, updated to display additional score
const html = `<p>Score 1 = ${score1}</p>
    <p>Score 2 = ${score2}</p>
    <p>Score 3 = ${score3}</p>
    <p>Score 4 = ${score4}</p>
    <p>Average score = ${average}</p>`;
document.write(html);

//code to display scores in an alert box
const dialogBoxMessage = `
Score 1 = ${score1}
Score 2 = ${score2}
Score 3 = ${score3}
Score 4 = ${score4}
Average score = ${average}`;

alert(dialogBoxMessage);