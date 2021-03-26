// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Holdings Pie Chart
var ctx = document.getElementById("holdingsPieChart");
var holdingsPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: pitem_tickers,
    datasets: [{
      labels: pitem_tickers,
      data: pitem_holdings,
      backgroundColor: chart_colors,
      hoverBackgroundColor: chart_hover_colors,
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
