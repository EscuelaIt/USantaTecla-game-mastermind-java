<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="generator" content="Asciidoctor 2.0.8">
<meta name="author" content="Santa Tecla">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic%7CNoto+Serif:400,400italic,700,700italic%7CDroid+Sans+Mono:400,700">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="book">
<div id="header">
<h1>Mastermind. Solución 11.4. <strong>mvp.pm.+proxy</strong></h1>
<div class="details">
<span id="author" class="author">Santa Tecla</span><br>
<span id="email" class="email"><a href="mailto:parqueNaturalSantaTecla@gmail.com">parqueNaturalSantaTecla@gmail.com</a></span><br>
<span id="revnumber">version 0.0.1</span>
</div>
<div id="toc" class="toc">
<div id="toctitle">Índice</div>
<ul class="sectlevel1">
<li><a href="#requisitos-4-clienteservidor">Requisitos 4. <strong>Cliente/Servidor</strong></a></li>
<li><a href="#vista-de-lógicadiseño">Vista de Lógica/Diseño</a>
<ul class="sectlevel2">
<li><a href="#arquitectura">Arquitectura</a></li>
<li><a href="#paquete-mastermind">Paquete <em>mastermind</em></a></li>
<li><a href="#paquete-mastermind-views">Paquete <em>mastermind.views</em></a></li>
<li><a href="#paquete-mastermind-controllers">Paquete <em>mastermind.controllers</em></a></li>
<li><a href="#paquete-mastermind-controllers-implementation">Paquete <em>mastermind.controllers.implementation</em></a></li>
<li><a href="#paquete-mastermind-distributed">Paquete <em>mastermind.distributed</em></a></li>
<li><a href="#paquete-mastermind-distributed-dispatchers">Paquete <em>mastermind.distributed.dispatchers</em></a></li>
<li><a href="#paquete-mastermind-models">Paquete <em>mastermind.models</em></a></li>
<li><a href="#paquete-mastermind-utils">Paquete <em>mastermind.utils</em></a></li>
</ul>
</li>
<li><a href="#calidad-de-software">Calidad de Software</a>
<ul class="sectlevel2">
<li><a href="#diseño">Diseño</a></li>
<li><a href="#rediseño">Rediseño</a></li>
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
<h2 id="requisitos-4-clienteservidor">Requisitos 4. <strong>Cliente/Servidor</strong></h2>
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
<p><em>Funcionalidad: <strong>Básica</strong> + <strong>undo/redo</strong></em></p>
</li>
<li>
<p><em>Interfaz: <strong class="line-through">Gráfica</strong> y <strong>Texto</strong></em></p>
</li>
<li>
<p><em>Distribución: <strong>Standalone</strong> + <strong>Client/Server</strong></em></p>
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
<p><strong>Modelo/Vista/Presentador</strong> con <strong>Presentador del Modelo</strong> con <strong>Vista Achicada</strong></p>
<div class="ulist">
<ul>
<li>
<p><span class="lime-background"><strong>Patrón Proxy</strong></span>, para la ejecución distribuida</p>
</li>
</ul>
</div>
</li>
</ul>
</div>
<div class="sect2">
<h3 id="arquitectura">Arquitectura</h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/arquitecturaVersion11.svg" alt="arquitecturaVersion11" width="867" height="650">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind">Paquete <em>mastermind</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindVersion11.svg" alt="mastermindVersion11" width="606" height="355">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-views">Paquete <em>mastermind.views</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindViewsVersion11.svg" alt="mastermindViewsVersion11" width="2363" height="1203">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-controllers">Paquete <em>mastermind.controllers</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindControllersVersion11.svg" alt="mastermindControllersVersion11" width="1190" height="1093">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-controllers-implementation">Paquete <em>mastermind.controllers.implementation</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindControllersImplementation.svg" alt="mastermindControllersImplementation" width="1848" height="514">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-distributed">Paquete <em>mastermind.distributed</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindDistributed.svg" alt="mastermindDistributed" width="2373" height="1109">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-distributed-dispatchers">Paquete <em>mastermind.distributed.dispatchers</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindDistributedDispatchers.svg" alt="mastermindDistributedDispatchers" width="4251" height="656">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-models">Paquete <em>mastermind.models</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindModelsVersion11.svg" alt="mastermindModelsVersion11" width="1157" height="1711">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-utils">Paquete <em>mastermind.utils</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindUtilsVerson11.svg" alt="mastermindUtilsVerson11" width="1166" height="781">
</div>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="calidad-de-software">Calidad de Software</h2>
<div class="sectionbody">
<div class="sect2">
<h3 id="diseño">Diseño</h3>
<div class="ulist">
<ul>
<li>
<p><span class="red line-through"><em><strong>Baja Cohesión</strong>: de Lógica y Controladores que controlan y comunican</em></span></p>
</li>
<li>
<p><span class="red line-through"><em><strong>Alto Acoplamiento</strong>: de Lógica y Controladores a tecnologías de comunicación</em></span></p>
</li>
<li>
<p><span class="red line-through"><em><strong>Open/Close</strong>: en Lógica y Controladores cuando hay que cambiar el código de éstos con nuevas tecnologías de comunicación</em></span></p>
</li>
</ul>
</div>
</div>
<div class="sect2">
<h3 id="rediseño">Rediseño</h3>
<div class="ulist">
<ul>
<li>
<p><span class="red line-through"><em><strong>Clases Grandes</strong>: de Controladores con distintas ramas para distintas tecnologías de comunicación</em></span></p>
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
<img src="build/docs/asciidoc/images/diagramaImplementacionStandalone.svg" alt="diagramaImplementacionStandalone" width="1397" height="158">
</div>
</div>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaImplementacionClient.svg" alt="diagramaImplementacionClient" width="1605" height="158">
</div>
</div>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaImplementacionServer.svg" alt="diagramaImplementacionServer" width="1891" height="158">
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-desplieguefísica">Vista de Despliegue/Física</h2>
<div class="sectionbody">
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaDespliegue.svg" alt="diagramaDespliegue" width="703" height="278">
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
Last updated 2019-10-01 14:15:11 +0200
</div>
</div>
</html>