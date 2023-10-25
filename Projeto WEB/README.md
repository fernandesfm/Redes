# Projeto WEB e NAT

Página web desenvolvida em PHP usando servidor Apache2 e acesso a outros dispositivos configurado usando o serviço ngrok.

## Para configurar o Apache e PHP:

Instalação e Execução do Apache no WSL com Sysvinit:
```
sudo apt install apache2

sudo service apache2 start

sudo service apache2 status
```

Instalação do PHP e seu módulo para Apache:
```
sudo apt install php libapache2-mod-php
```

Verificação do módulo PHP:
```
sudo a2enmod php7.4
```

Reinicialização do Apache para aplicar as configurações:
```
sudo service apache2 restart
```

## Para criar a página dinâmica:
Copie do arquivo "conteudo-dinamico.php" para o diretório raiz do Apache:
```
cp <seu_diretorio>/conteudo-dinamico.php /var/www/html
```
Acesse o conteúdo da página:
```
1. http://localhost/conteudo-dinamico.php

2. http://127.0.0.1/conteudo-dinamico.php
```
Caso tudo esteja correto e os componentes em execução, a página deve ser exibida por meio de qualquer um dos dois links acima.

## Para configurar o Ngrok

Instalação do serviço via apt:
```
curl -s https://ngrok-agent.s3.amazonaws.com/ngrok.asc | sudo tee /etc/apt/trusted.gpg.d/ngrok.asc >/dev/null && echo "deb https://ngrok-agent.s3.amazonaws.com buster main" | sudo tee /etc/apt/sources.list.d/ngrok.list && sudo apt update && sudo apt install ngrok
```

Inserção do token de autorização ao arquivo de configuração do Ngrok
```
ngrok config add-authtoken <seu_token>
```
Iniciando o túnel do Ngrok
```
ngrok http <porta_aqui> --authtoken <seu_token_aqui>
```

Caso tudo esteja correto e os componentes em execução, uma URL pública sera gerada e o acesso a página dinâmica poderá ser feito pelo celular por esse endereço.
