
var chart_colors = chartColors(
    [color_primary, color_secondary, color_success, color_info, color_warning],
    pitems.length / 5
);
var chart_hover_colors = chartColors(
    [color_primary_hover, color_secondary_hover, color_success_hover, color_info_hover, color_warning_hover],
    pitems.length / 5
);



// ChartColors
function chartColors(colors, repeat) {

  var repeated_colors = [];
  for (var i = 0; i < repeat; i++)
  {
      for (var j = 0; j < colors.length; j++) {
        repeated_colors.push(colors[j]);
      }
  }
  return repeated_colors;
}
