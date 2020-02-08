function change1() {
	var id1 = document.querySelector('#id1').value
	var content1 = document.querySelector('#content1').value
	var element = document.querySelector("#" + id1);
	element.innerText = content1;
}

function change2() {
	var id2 = document.querySelector('#id2').value
	var style2 = document.querySelector('#style2').value
	var element = document.querySelector("#" + id2);
	element.className = style2;
}

var count = 0;
function change3() {
	var tag3 = document.querySelector('#tag3').value
	var content3 = document.querySelector('#content3').value
	var element = document.createElement(tag3);
	var newdiv = document.getElementById('newdiv')
	if(!newdiv) {
		newdiv = document.createElement('div')
		newdiv.id = 'newdiv'
		var body = document.querySelector("body");
		body.appendChild(newdiv)
	}
	element.id = "new" + count.toString();
	count += 1;
	element.innerText = content3 + " with ID " + element.id + ".";
	newdiv.appendChild(element);
}

function change4() {
	var id4 = document.querySelector('#id4').value
	var element = document.querySelector("#" + id4);
	var body = document.querySelector("body");
	if(id4 === 'newdiv')
		count--;
	body.removeChild(element);
}

function change5() {
	var element = document.querySelector("#h5");
	element.style = "animation: animate 3s infinite;"
}