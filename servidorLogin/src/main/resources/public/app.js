var usuario=null;
var contrasena=null;


	function hacerPost(datos){
		console.log("h");
		let promise = new Promise( (resolve, reject) => {
				var putPromise = $.ajax({
				url: "/login",
				type: 'POST',
				data: JSON.stringify(datos),
				contentType: "application/json"
		}).then (function (data){
				callback(data);
		}).catch(error => $("#titulo").html("Datos insertados incorrectos"));
		});

		return promise;
	}
	function callback(data){
		console.log(data);
		var columnas="";
		$("#titulo").html("Estudiantes de AREP 2021-2")
		for(const property in data){
			columnas=columnas+'<tr class="clm_principal">'
			columnas=columnas+"<td>"+data[property].nombre+"</td>";
			columnas=columnas+"<td>"+data[property].correo+"</td>";
			columnas=columnas+"<td>"+data[property].sexo+"</td>";
			columnas=columnas+"</tr>";
		}
		$("#estudiantes").append(columnas);
	}
	
	$(document).ready(function(){
                
		$("#button").click(function(){	
			$(".clm_principal").remove();
			usuario=$("#usuario").val();
			contrasena=$("#contrasena").val();
			console.log(usuario,contrasena);
			datos={"usuario":usuario,"contrasena":contrasena}
			console.log(datos);
			hacerPost(datos).then(function (data){
				
			});
		
		});

	});
