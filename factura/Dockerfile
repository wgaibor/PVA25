 # Usa la imagen oficial de MySQL 5.7
FROM mysql:5.7

# Establece la contraseña de root para MySQL.
# ¡IMPORTANTE! Cambia 'tu_contraseña_secreta' por una contraseña segura.
ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=my_database
ENV MYSQL_USER=my_user
ENV MYSQL_PASSWORD=my_password

# Expone el puerto estándar de MySQL
EXPOSE 3306

# El directorio /var/lib/mysql es donde MySQL almacena sus datos.
# La imagen base de MySQL ya define esto como un VOLUMEN,
# lo que significa que Docker lo manejará para la persistencia
# si montas un volumen en este punto.
# No es estrictamente necesario añadirlo aquí de nuevo si usas la imagen oficial,
# pero lo incluyo para mayor claridad.
VOLUME /var/lib/mysql
