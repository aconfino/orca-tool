<%@attribute name="name" required="true" %>
<%@attribute name="title" required="true" %>
<%@attribute name="value" required="true" %>
<%@attribute name="href" required="false" %>

<div class="single-field">
	<br />
	<h6>
		<label for="${pageScope.name}" class="fieldLabel">${pageScope.title} Weight:</label>
		<div class="${pageScope.name}WeightLabel">${pageScope.value}</div>
		<input type="hidden" name="${pageScope.name}" value="${pageScope.value}" class="${pageScope.name}" readonly="readonly" /> 
		<a href="${pageScope.href}" id="${pageScope.name}PopUp">(read more)</a>
	</h6>
	<div class="${pageScope.name}Slider slider"></div>
</div>

<script>
$(function(){
	$(".${pageScope.name}Slider").slider({
		min: .01,
		max: 1,
		step: .01,
		slide: function(event, ui) {
			$(".${pageScope.name}").val(Math.round(ui.value*100));  // integer version - hidden
			$(".${pageScope.name}WeightLabel").html(ui.value); // displayed to user, decimal
		}
	});
	var startValue = $(".${pageScope.name}").val()/100;
	$('.${pageScope.name}Slider').slider("option", "value", startValue);
	$(".${pageScope.name}WeightLabel").html(startValue);

// Dialog popup
	var $dialog = $('<div></div>')
		.html('Use this slider to weigh metrics that are the most important to your evaluation.  If this is a key metric to your evaluation, give it a higher value.  Conversly, you can lower other metrics than are not as important.')
		.dialog({
			autoOpen: false,
			title: '${pageScope.title} Weight'
		});
	$('#${pageScope.name}PopUp').click(function() {
		$dialog.dialog('open');
		// prevent the default action, e.g., following a link
		return false;
	});
});
</script>