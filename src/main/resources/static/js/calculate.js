
// Number Formatting (ChartJS)
function number_format(number, decimals=0, dec_point='.', thousands_sep=',') {
  // *     example: number_format(1234.56, 2, ',', ' ');
  // *     return: '1 234,56'
  number = (number + '').replace(',', '').replace(' ', '');
  var n = !isFinite(+number) ? 0 : +number,
    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
    sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
    dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
    s = '',
    toFixedFix = function(n, prec) {
      var k = Math.pow(10, prec);
      return '' + Math.round(n * k) / k;
    };
  // Fix for IE parseFloat(0.55).toFixed(0) = 0;
  s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
  if (s[0].length > 3) {
    s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
  }
  if ((s[1] || '').length < prec) {
    s[1] = s[1] || '';
    s[1] += new Array(prec - s[1].length + 1).join('0');
  }
  return s.join(dec);
}

// Total Holdings
var total_holdings = sum(pitem_holdings);

// Total Profit/Loss
var total_pls = sum(pitem_total_pls);

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
