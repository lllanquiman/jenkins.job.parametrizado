#!/bin/bash
echo "Bienvenid/a al planeta $planeta"
if [ "$agente" = true ]
then
	echo "Preparese para la misión agente X, que la fuerza de acompañe..."
else
	echo "Disfruta del planeta humano/a $nombre, trata de no morir..."
fi
echo "..."
sleep 10
echo "¡Suerte! La necesitarás "
