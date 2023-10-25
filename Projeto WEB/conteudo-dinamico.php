<!DOCTYPE html>
<html>
<head>
    <title>Conteúdo Dinâmico</title>
</head>
<body>
    <h1>Informações Dinâmicas</h1>
    <p>IP: <?php echo $_SERVER['REMOTE_ADDR']; ?></p>
    <p>Data e Hora: <span id="data-hora"></span>

    <script>
        function atualizarDataHora() {
            var dataHoraElement = document.getElementById("data-hora");
            var dataHora = new Date();
            dataHoraElement.textContent = dataHora.toLocaleString();
        }

        atualizarDataHora();
        setInterval(atualizarDataHora, 1000); // Atualiza a cada segundo
    </script>
</body>
</html>
