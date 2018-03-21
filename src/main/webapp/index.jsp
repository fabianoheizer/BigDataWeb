<html>
	<head>
		<title>UFRJ - Escola Politécnica - BigData</title>
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
			$(document).ready(
				function(){
					$.ajax({
						url: "gerarGraficos",
						dataType: "JSON",
						success: function(result){
							
							google.charts.load('current', {
								'packages' : ['corechart']
							});
							
							google.charts.setOnLoadCallback(function() {
								drawChartQtdPedidos(result);	
							});
						}
					});
					
					function drawChartQtdPedidos(result){
						var qtd_pedidos_origem_data = new google.visualization.DataTable();
						
						qtd_pedidos_origem_data.addColumn('string', 'Origem');
						qtd_pedidos_origem_data.addColumn('number', 'Quantidade_pedidos');
						
						var qtd_pedidos_origem = [ ];
						
						$.each(result, function(i, obj) {
							qtd_pedidos_origem.push([ obj.origem, obj.quantidade_pedidos]);
						});
						
						qtd_pedidos_origem_data.addRows(qtd_pedidos_origem);
						
						var piechart_options = {
							title: 'Quantidade de pedidos por origem',
							width: 400,
							height: 300
						};
						
						var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
						piechart.draw(qtd_pedidos_origem_data, piechart_options);
						
						var barchart_options = {
							title: 'Quantidade de pedidos por origem',
							width: 400,
							height: 300,
							legend: 'none'
						};
						
						var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
						barchart.draw(qtd_pedidos_origem_data, barchart_options);
					}
				});
		</script>
	</head>

	<body>
		
		<div style="text-align: center;">
			<h1 >
				<font face="verdana">Escola Politécnica de Engenharia</font> <br>
				<font face="verdana">Trabalho de BigData</font>
			</h1>
			
		</div>
		
		<table class="columns" style="margin-left: auto;margin-right: auto;">
			<tr>
				<td>
					<div id="piechart_div" style="border: 1px solid #ccc"></div>
				</td>
				<td>
					<div id="barchart_div" style="border: 1px solid #ccc"></div>
				</td>
			</tr>
		</table>
		
		<div style="text-align: center;">
			<font face="verdana">
				<b>Grupo:</b><br>
				Fabiano Heizer<br>
				Karolyne Loback<br>
				Marcelo Polito
			</font>
		</div>
	</body>
	
</html>
