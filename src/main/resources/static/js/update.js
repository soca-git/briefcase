
var currency_symbol = "$";
var percentage_symbol = "%";
var ihtml = "";

// Total Holdings
ihtml = currency_symbol + number_format(Math.round(total_holdings));
document.getElementById("total_holdings").innerHTML = ihtml;

// Total Profit/Loss
ihtml = currency_symbol + number_format(Math.round(total_pls));
document.getElementById("total_pls").innerHTML = ihtml;

if (total_pls > 0)
{
    document.getElementById("total_pls_card").classList.remove('border-left-danger');
    document.getElementById("total_pls_card").classList.add('border-left-success');
    document.getElementById("total_pls_heading").classList.remove('text-danger');
    document.getElementById("total_pls_heading").classList.add('text-success');
    document.getElementById("total_pls_heading").innerHTML = "Total Profit";
}
else
{
    document.getElementById("total_pls_card").classList.remove('border-left-success');
    document.getElementById("total_pls_card").classList.add('border-left-danger');
    document.getElementById("total_pls_heading").classList.remove('text-success');
    document.getElementById("total_pls_heading").classList.add('text-danger');
    document.getElementById("total_pls_heading").innerHTML = "Total Loss";
}

// Largest Position Percentage
ihtml = largest_position_ticker + ' @ ' + Math.floor(largest_position_percentage) + percentage_symbol;
document.getElementById("largest_position_percentage").innerHTML = ihtml;
