
var currency_symbol = "$";
var percentage_symbol = "%";
document.getElementById("total_holdings").innerHTML = currency_symbol + Math.round(total_holdings);
document.getElementById("average_holdings").innerHTML = currency_symbol + Math.round(average_holdings);
document.getElementById("largest_position_percentage").innerHTML = largest_position_ticker + ' @ ' + Math.floor(largest_position_percentage) + percentage_symbol;
