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
<h1>Mastermind. Solución 15.6. <strong>mvp.pm.+prototype</strong></h1>
<div class="details">
<span id="author" class="author">Santa Tecla</span><br>
<span id="email" class="email"><a href="mailto:parqueNaturalSantaTecla@gmail.com">parqueNaturalSantaTecla@gmail.com</a></span><br>
<span id="revnumber">version 0.0.1</span>
</div>
<div id="toc" class="toc">
<div id="toctitle">Índice</div>
<ul class="sectlevel1">
<li><a href="#requisitos-6-bases-de-datos">Requisitos 6. <strong>Bases de Datos</strong></a></li>
<li><a href="#vista-de-lógicadiseño">Vista de Lógica/Diseño</a>
<ul class="sectlevel2">
<li><a href="#arquitectura">Arquitectura</a></li>
<li><a href="#paquete-mastermind">Paquete <em>mastermind</em></a></li>
<li><a href="#paquete-mastermind-controllers">Paquete <em>mastermind.controllers</em></a></li>
<li><a href="#paquete-mastermind-controllers-implementation">Paquete <em>mastermind.controllers.implementation</em></a></li>
<li><a href="#paquete-mastermind-distributed">Paquete <em>mastermind.distributed</em></a></li>
<li><a href="#paquete-mastermind-distributed-dispatchers">Paquete <em>mastermind.distributed.dispatchers</em></a></li>
<li><a href="#paquete-mastermind-models">Paquete <em>mastermind.models</em></a></li>
<li><a href="#paquete-mastermind-models-dao">Paquete <em>mastermind.models.dao</em></a></li>
<li><a href="#paquete-mastermind-models-database">Paquete <em>mastermind.models.dataBase</em></a></li>
<li><a href="#paquete-mastermind-models-files">Paquete <em>mastermind.models.Files</em></a></li>
<li><a href="#paquete-mastermind-types">Paquete <em>mastermind.types</em></a></li>
<li><a href="#paquete-mastermind-views">Paquete <em>mastermind.views</em></a></li>
<li><a href="#paquete-mastermind-views-menus">Paquete <em>mastermind.views.menus</em></a></li>
<li><a href="#paquete-mastermind-views-models">Paquete <em>mastermind.views.models</em></a></li>
<li><a href="#paquete-santatecla-utils">Paquete <em>santaTecla.utils</em></a></li>
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
<h2 id="requisitos-6-bases-de-datos">Requisitos 6. <strong>Bases de Datos</strong></h2>
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
<p><em>Persistencia: <strong>Ficheros</strong> + <span class="lime-background"><strong>Bases de Datos</strong></span></em></p>
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
<p><strong class="black lime-background">Patrón Prototype</strong>, para tecnología de persistencia</p>
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
<img src="build/docs/asciidoc/images/arquitectura.svg" alt="arquitectura" width="2143" height="880">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind">Paquete <em>mastermind</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermind.svg" alt="mastermind" width="1396" height="478">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-controllers">Paquete <em>mastermind.controllers</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindControllers.svg" alt="mastermindControllers" width="1836" height="1055">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-controllers-implementation">Paquete <em>mastermind.controllers.implementation</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/MastermindControllersImplementation.svg" alt="MastermindControllersImplementation" width="3254" height="720">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-distributed">Paquete <em>mastermind.distributed</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/MastermindDistributed.svg" alt="MastermindDistributed" width="6625" height="795">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-distributed-dispatchers">Paquete <em>mastermind.distributed.dispatchers</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/MastermindDistributedDispatchers.svg" alt="MastermindDistributedDispatchers" width="11182" height="1044">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-models">Paquete <em>mastermind.models</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/MastermindModels.svg" alt="MastermindModels" width="1164" height="1946">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-models-dao">Paquete <em>mastermind.models.dao</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/MastermindModelsDao.svg" alt="MastermindModelsDao" width="1029" height="357">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-models-database">Paquete <em>mastermind.models.dataBase</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/MastermindModelsDataBase.svg" alt="MastermindModelsDataBase" width="835" height="699">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-models-files">Paquete <em>mastermind.models.Files</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindModelsFiles.svg" alt="mastermindModelsFiles" width="1616" height="822">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-types">Paquete <em>mastermind.types</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindTypes.svg" alt="mastermindTypes" width="317" height="233">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-views">Paquete <em>mastermind.views</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindViews.svg" alt="mastermindViews" width="1863" height="534">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-views-menus">Paquete <em>mastermind.views.menus</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindViewsMenus.svg" alt="mastermindViewsMenus" width="2630" height="834">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-mastermind-views-models">Paquete <em>mastermind.views.models</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/mastermindViewsModels.svg" alt="mastermindViewsModels" width="2035" height="947">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-santatecla-utils">Paquete <em>santaTecla.utils</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/santaTecla.utils.svg" alt="santaTecla.utils" width="1163" height="767">
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
<p><span class="red line-through"><em><strong>Baja Cohesión</strong>: Jerarquías de Herencia Paralelas: en clases principales</em></span></p>
</li>
</ul>
</div>
</div>
<div class="sect2">
<h3 id="rediseño">Rediseño</h3>

</div>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-desarrolloimplementación">Vista de Desarrollo/Implementación</h2>
<div class="sectionbody">
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaImplementacionStandalone.svg" alt="diagramaImplementacionStandalone" width="1618" height="158">
</div>
</div>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaImplementacionClient.svg" alt="diagramaImplementacionClient" width="1826" height="158">
</div>
</div>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaImplementacionServer.svg" alt="diagramaImplementacionServer" width="2112" height="158">
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
Last updated 2019-10-14 20:48:43 +0200
</div>
</div>
</html>