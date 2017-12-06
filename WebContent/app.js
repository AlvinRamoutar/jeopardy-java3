/**
 * 
 */
window.addEventListener("DOMContentLoaded", function() {
	for (var r = 0; r < 5; r++) {
		var row = document.getElementById("lv" + (r + 1));
		for (var c = 0; c < 6; c++) {
			var cell = document.createElement("div");
			cell.id = "c" + c + "_lv" + r + 1;
			cell.setAttribute("class", "col-sm question");
			var cellButton = document.createElement("button");
			cellButton.setAttribute("class", "question questionButton");
			cellButton.setAttribute("type", "submit");
			cellButton.setAttribute("value", "c" + (c + 1) + "_lv" + (r + 1));
			cellButton.setAttribute("name", "chosenQuestion");
			cellButton.textContent = "$" + 200 * (r + 1);
			cell.appendChild(cellButton);
			row.appendChild(cell);
		}
	}

});