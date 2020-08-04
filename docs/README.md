<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="generator" content="Asciidoctor 2.0.8">
<meta name="author" content="Santa Tecla">
<title>Mastermind. Solución 7.2. mvp.pm.-doubleDispatching</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic%7CNoto+Serif:400,400italic,700,700italic%7CDroid+Sans+Mono:400,700">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="book">
<div id="header">
<h1>Mastermind. Solución 7.2. <strong>mvp.pm.-doubleDispatching</strong></h1>
<div class="details">
<span id="author" class="author">Santa Tecla</span><br>
<span id="email" class="email"><a href="mailto:parqueNaturalSantaTecla@gmail.com">parqueNaturalSantaTecla@gmail.com</a></span><br>
<span id="revnumber">version 0.0.1</span>
</div>
<div id="toc" class="toc">
<div id="toctitle">Índice</div>
<ul class="sectlevel1">
<li><a href="#requisitos-2-gráficos">Requisitos 2. <strong>Gráficos</strong></a></li>
<li><a href="#vista-de-lógicadiseño">Vista de Lógica/Diseño</a>
<ul class="sectlevel2">
<li><a href="#arquitectura">Arquitectura</a></li>
<li><a href="#paquete-mastermind">Paquete <em>mastermind</em></a></li>
<li><a href="#paquete-mastermind-views">Paquete <em>mastermind.views</em></a></li>
<li><a href="#paquete-mastermind-views-console">Paquete <em>mastermind.views.console</em></a></li>
<li><a href="#paquete-mastermind-views-graphics">Paquete <em>mastermind.views.graphics</em></a></li>
<li><a href="#paquete-mastermind-controllers">Paquete <em>mastermind.controllers</em></a></li>
<li><a href="#paquete-mastermind-models">Paquete <em>mastermind.models</em></a></li>
<li><a href="#paquete-mastermind-utils">Paquete <em>mastermind.utils</em></a></li>
</ul>
</li>
<li><a href="#calidad-del-software">Calidad del Software</a>
<ul class="sectlevel2">
<li><a href="#diseño">Diseño</a></li>
</ul>
</li>
<li><a href="#vista-de-desarrolloimplementación">Vista de Desarrollo/Implementación</a></li>
<li><a href="#vista-de-desplieguefísica">Vista de Despliegue/Física</a></li>
<li><a href="#vista-de-procesos">Vista de Procesos</a></li>
</ul>
</div>
</div>
<div id="content">
<div class="sect1">
<h2 id="requisitos-2-gráficos">Requisitos 2. <strong>Gráficos</strong></h2>
<div class="sectionbody">
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 50%;">
<col style="width: 50%;">
</colgroup>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="ulist">
<ul>
<li>
<p><a href="https://en.wikipedia.org/wiki/Mastermind_(board_game)"><strong>Wiki</strong></a> - <a href="https://www.youtube.com/watch?v=2-hTeg2M6GQ"><strong>Youtube</strong></a></p>
<div class="ulist">
<ul>
<li>
<p><em>Funcionalidad: <strong>Básica</strong></em></p>
</li>
<li>
<p><em>Interfaz: <strong>Gráfica</strong> y <strong>Texto</strong></em></p>
</li>
<li>
<p><em>Distribución: <strong>Standalone</strong></em></p>
</li>
<li>
<p><em>Persistencia: <strong>No</strong></em></p>
</li>
</ul>
</div>
</li>
</ul>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/Dibujo.jpg" alt="Dibujo">
</div>
</div></div></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-lógicadiseño">Vista de Lógica/Diseño</h2>
<div class="sectionbody">
<div class="ulist">
<ul>
<li>
<p>Modelo/Vista/Presentador con Presentador del Modelo con <strong class="black lime-background">Vista Achicda</strong></p>
</li>
</ul>
</div>
<div class="sect2">
<h3 id="arquitectura">Arquitectura</h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/arquitecturaVersion7.svg" alt="arquitecturaVersion7" width="932" height="650">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind">Paquete <em>mastermind</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindVersion7.svg" alt="mastermindVersion7" width="773" height="355">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-views">Paquete <em>mastermind.views</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindViewsVersion7.svg" alt="mastermindViewsVersion7" width="785" height="632">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-views-console">Paquete <em>mastermind.views.console</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindViewsConsoleVersion7.svg" alt="mastermindViewsConsoleVersion7" width="1371" height="656">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-views-graphics">Paquete <em>mastermind.views.graphics</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindViewsGraphicsVersion7.svg" alt="mastermindViewsGraphicsVersion7" width="1845" height="960">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-controllers">Paquete <em>mastermind.controllers</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindcontrollersVersion7.svg" alt="mastermindcontrollersVersion7" width="1079" height="764">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-models">Paquete <em>mastermind.models</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindModelsVersion7.svg" alt="mastermindModelsVersion7" width="682" height="930">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-utils">Paquete <em>mastermind.utils</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindUtilsVersion7.svg" alt="mastermindUtilsVersion7" width="456" height="575">
</div>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="calidad-del-software">Calidad del Software</h2>
<div class="sectionbody">
<div class="sect2">
<h3 id="diseño">Diseño</h3>
<div class="ulist">
<ul>
<li>
<p><span class="red line-through"><em><strong>DRY</strong>: en las clases de vistas que asume el flujo de control y se repite en mastermind.views.console.ProposalView y mastermind.views.graphics.GameView</em></span></p>
</li>
<li>
<p><span class="red"><em><strong>Principio de Sustitución de Liskov</strong>: las vistas preguntan por el tipo de controlador polimórfico</em></span></p>
</li>
</ul>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-desarrolloimplementación">Vista de Desarrollo/Implementación</h2>
<div class="sectionbody">
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaImplementacion.svg" alt="diagramaImplementacion" width="1963" height="158">
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-desplieguefísica">Vista de Despliegue/Física</h2>
<div class="sectionbody">
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaDespliegue.svg" alt="diagramaDespliegue" width="203" height="207">
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-procesos">Vista de Procesos</h2>
<div class="sectionbody">
<div class="ulist">
<ul>
<li>
<p>No hay concurrencia</p>
</li>
</ul>
</div>
</div>
</div>
</div>
<div id="footer">
<div id="footer-text">
Version 0.0.1<br>
Last updated 2019-10-01 14:14:22 +0200
</div>
</div>
</html>