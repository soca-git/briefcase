// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

function fillPieChartColors(colors, repeat) {

  var repeated_colors = [];
  for (var i = 0; i < repeat; i++)
  {
      for (var j = 0; j < colors.length; j++) {
        repeated_colors.push(colors[j]);
      }
  }
  return repeated_colors;
}

var pie_colors = fillPieChartColors(
    [color_primary, color_secondary, color_success, color_info, color_warning],
    10
);
var pie_hover_colors = fillPieChartColors(
    [color_primary_hover, color_secondary_hover, color_success_hover, color_info_hover, color_warning_hover],
    10
);

// Holdings Pie Chart
var ctx = document.getElementById("holdingsPieChart");
var holdingsPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: pitem_tickers,
    datasets: [{
      labels: pitem_tickers,
      data: pitem_holdings,
      backgroundColor: pie_colors,
      hoverBackgroundColor: pie_hover_colors,
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
      callbacks: {
        label: function(tooltipItem, chart) {
          var datasetLabel = chart.datasets[0].labels[tooltipItem['index']] || '';
          return datasetLabel + ': $' + number_format(chart.datasets[0].data[tooltipItem['index']]);
        }
      }
    },
    legend: {
      display: true,
      position: 'bottom'
    },
    cutoutPercentage: 80,
  },
});
