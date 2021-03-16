
// Total Holdings
var total_holdings = sum(pitem_holdings);

// Average Holdings
var average_holdings = average(pitem_holdings);

// Largest Position Percentage
var largest_position = Math.max(...pitem_holdings);
var largest_position_index = pitem_holdings.indexOf(largest_position);
var largest_position_ticker = pitem_tickers[largest_position_index];
var largest_position_percentage = largest_position / total_holdings * 100;

function average(numbers)
{
    var total = sum(numbers);
    return total/numbers.length;
}

function sum(numbers)
{
    var total = 0;
    for (i = 0; i < numbers.length; i++)
    {
        total += numbers[i];
    }
    return total;
}
