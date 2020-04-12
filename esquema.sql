
CREATE TABLE test.dbo.CTG_PRODUCT (
	CTG_PRODUCT_ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
	CTG_PRODUCT_NAME varchar(200) NOT NULL,
	CTG_PRODUCT_QUANTITY int NOT NULL,
	CTG_PRODUCT_PRICE decimal(9,2) NOT NULL,
	CTG_PRODUCT_DESCRIPTION varchar(300),
	CTG_PRODUCT_IMAGE varbinary(max),
	CTG_PRODUCT_SKU int,
	CTG_PRODUCT_ACTIVE bit
)

CREATE TABLE test.dbo.CTG_TEMPLATE (
	CTG_TEMPLATE_ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
	CTG_TEMPLATE_BODY varchar(MAX) NOT NULL,
	CTG_TEMPLATE_IDENTIFIER varchar(20) NOT NULL,
	CTG_TEMPLATE_ACTIVE bit NULL
)

CREATE TABLE test.dbo.SGD_USER (
	SGD_USER_ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
	SGD_USER_NAME varchar(200),
	SGD_USER_TEL int,
	SGD_USER_USERNAME varchar(100) UNIQUE,
	SGD_USER_BORNDATE date,
	SGD_USER_MAIL varchar(200) UNIQUE,
	SGD_USER_USERPWD varchar(100),
	SGD_USER_ACTIVE bit,
	SGD_USER_ROLE varchar(30),
	SGD_USER_RESETPWD datetime
)

INSERT INTO test.dbo.CTG_PRODUCT (CTG_PRODUCT_ID,CTG_PRODUCT_NAME,CTG_PRODUCT_QUANTITY,CTG_PRODUCT_PRICE,CTG_PRODUCT_DESCRIPTION,CTG_PRODUCT_IMAGE,CTG_PRODUCT_SKU,CTG_PRODUCT_ACTIVE) VALUES 
(2,'Verduras',20,8.50,'Primer producto en stock',NULL,856612322,1)
,(3,'Salsa Verde',20,5.50,'Segundo producto en stock',NULL,123456789,1)
,(4,'Product 2',10,5.50,'Segundo producto en stock',NULL,123456789,0)
,(5,'Galletas',10,5.50,'Segundo producto en stock',NULL,123456789,1)
,(6,'Leche MOD',20,7.50,'Leche en stock',NULL,123456719,1)
;

INSERT INTO test.dbo.SGD_USER (SGD_USER_ID,SGD_USER_NAME,SGD_USER_TEL,SGD_USER_USERNAME,SGD_USER_BORNDATE,SGD_USER_MAIL,SGD_USER_USERPWD,SGD_USER_ACTIVE,SGD_USER_ROLE,SGD_USER_RESETPWD) VALUES 
(1,'Irvin Orantes',74148888,'MilesDraco','2020-02-08','irvinldt@gmail.com','{bcrypt}$2a$12$ECZi5p1ha4t/ioUjXSP2reB2oNdeRnJVOcLQ6zkRTXsZFWVXS/igi',1,'admin','2020-04-12 15:00:59.917')
,(3,'Erick Merino',74141888,'Onich','2020-04-10','irvin177@hotmail.es','Desa2020$',1,'client',NULL)
,(4,'Irvin Orantes',74141888,'IrvinOrantes','0008-03-12','irvin1@mail.com','{bcrypt}$2y$12$fIghU025UASLezX/BM3L/OLwENCJf9vYETU2gvpolw7/tSu7ybPDS',1,'admin',NULL)
,(5,'Irvin Orantes',74141888,'IrvinOrantes2','0008-03-12','irvin2@mail.com','{bcrypt}$2a$12$XwDlsD4Sqv5UJZ2rTz3n.eCwOWvoG.ejAWI50r1WhijEJCDbD/4zC',0,'client',NULL)
,(6,'Irvin Orantes',74141888,'IrvinOrantes3','0008-03-12','irvin3@irvin.com','{bcrypt}$2y$12$fIghU025UASLezX/BM3L/OLwENCJf9vYETU2gvpolw7/tSu7ybPDS',1,'client',NULL)
,(7,'Irvin Orantes',74141888,'IrvinOrantes4','0008-03-12','irvin4@irvin.com','{bcrypt}$2a$12$pX5p8jLreQs3YMxN5k/aZep1lWR2AOMWzb8edqkmXdPUmBjfqFL4u',1,'admin',NULL)
;

INSERT INTO test.dbo.CTG_TEMPLATE (CTG_TEMPLATE_ID,CTG_TEMPLATE_BODY,CTG_TEMPLATE_IDENTIFIER,CTG_TEMPLATE_ACTIVE) VALUES 
(1,'<head>
<title>Rating Reminder</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta content="width=device-width" name="viewport">
<style type="text/css">
            @font-face {
              font-family: &#x27;Postmates Std&#x27;;
              font-weight: 600;
              font-style: normal;
              src: local(&#x27;Postmates Std Bold&#x27;), url(https://s3-us-west-1.amazonaws.com/buyer-static.postmates.com/assets/email/postmates-std-bold.woff) format(&#x27;woff&#x27;);
            }

            @font-face {
              font-family: &#x27;Postmates Std&#x27;;
              font-weight: 500;
              font-style: normal;
              src: local(&#x27;Postmates Std Medium&#x27;), url(https://s3-us-west-1.amazonaws.com/buyer-static.postmates.com/assets/email/postmates-std-medium.woff) format(&#x27;woff&#x27;);
            }

            @font-face {
              font-family: &#x27;Postmates Std&#x27;;
              font-weight: 400;
              font-style: normal;
              src: local(&#x27;Postmates Std Regular&#x27;), url(https://s3-us-west-1.amazonaws.com/buyer-static.postmates.com/assets/email/postmates-std-regular.woff) format(&#x27;woff&#x27;);
            }
        </style>
<style media="screen and (max-width: 680px)">
            @media screen and (max-width: 680px) {
                .page-center {
                  padding-left: 0 !important;
                  padding-right: 0 !important;
                }
                
                .footer-center {
                  padding-left: 20px !important;
                  padding-right: 20px !important;
                }
            }
        </style>
</head>
<body style="background-color: #f4f4f5;">
<table cellpadding="0" cellspacing="0" style="width: 100%; height: 100%; background-color: #f4f4f5; text-align: center;">
<tbody><tr>
<td style="text-align: center;">
<table align="center" cellpadding="0" cellspacing="0" id="body" style="background-color: #fff; width: 100%; max-width: 720px; height: 100%;">
<tbody><tr>
<td>
<table align="center" cellpadding="0" cellspacing="0" class="page-center" style="text-align: left; padding-bottom: 88px; width: 100%; padding-left: 120px; padding-right: 120px;">
<tbody>
<tr>
<td colspan="3" style="padding-top: 72px; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #000000; font-family: ''Postmates Std'', ''Helvetica'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Roboto'', ''Oxygen'', ''Ubuntu'', ''Cantarell'', ''Fira Sans'', ''Droid Sans'', ''Helvetica Neue'', sans-serif; font-size: 38px; font-smoothing: always; font-style: normal; font-weight: 600; letter-spacing: -2.6px; line-height: 52px; mso-line-height-rule: exactly; text-decoration: none;">Recuperacion de contraseña</td>
</tr>
<tr>
<td style="padding-top: 48px; padding-bottom: 48px;">
<table cellpadding="0" cellspacing="0" style="width: 100%">
<tbody><tr>
<td style="width: 100%; height: 1px; max-height: 1px; background-color: #d9dbe0; opacity: 0.81"></td>
</tr>
</tbody></table>
</td>
</tr>
<tr>
<td style="-ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #9095a2; font-family: ''Postmates Std'', ''Helvetica'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Roboto'', ''Oxygen'', ''Ubuntu'', ''Cantarell'', ''Fira Sans'', ''Droid Sans'', ''Helvetica Neue'', sans-serif; font-size: 16px; font-smoothing: always; font-style: normal; font-weight: 400; letter-spacing: -0.18px; line-height: 24px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 100%;">
                                      Este correo es para recuperar tu contraseña.
                                    </td>
</tr>
<tr>
<td style="padding-top: 24px; -ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #9095a2; font-family: ''Postmates Std'', ''Helvetica'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Roboto'', ''Oxygen'', ''Ubuntu'', ''Cantarell'', ''Fira Sans'', ''Droid Sans'', ''Helvetica Neue'', sans-serif; font-size: 16px; font-smoothing: always; font-style: normal; font-weight: 400; letter-spacing: -0.18px; line-height: 24px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 100%;">
                                      Ingrese en el siguiente enlace para poder ingresar nueva contraseña.
                                    </td>
</tr>
<tr>
<td>
<a data-click-track-id="37" href="https://postmates.com/" style="margin-top: 36px; -ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #ffffff; font-family: ''Postmates Std'', ''Helvetica'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Roboto'', ''Oxygen'', ''Ubuntu'', ''Cantarell'', ''Fira Sans'', ''Droid Sans'', ''Helvetica Neue'', sans-serif; font-size: 12px; font-smoothing: always; font-style: normal; font-weight: 600; letter-spacing: 0.7px; line-height: 48px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 220px; background-color: #00cc99; border-radius: 28px; display: block; text-align: center; text-transform: uppercase" target="_blank">
                                        Reinicio de Contraseña
                                      </a>
</td>
</tr>
</tbody></table>
</td>
</tr>
</tbody></table>
</body>','reset_pass',0)
,(2,'<head>
<title>Rating Reminder</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta content="width=device-width" name="viewport">
<style type="text/css">
            @font-face {
              font-family: &#x27;Postmates Std&#x27;;
              font-weight: 600;
              font-style: normal;
              src: local(&#x27;Postmates Std Bold&#x27;), url(https://s3-us-west-1.amazonaws.com/buyer-static.postmates.com/assets/email/postmates-std-bold.woff) format(&#x27;woff&#x27;);
            }

            @font-face {
              font-family: &#x27;Postmates Std&#x27;;
              font-weight: 500;
              font-style: normal;
              src: local(&#x27;Postmates Std Medium&#x27;), url(https://s3-us-west-1.amazonaws.com/buyer-static.postmates.com/assets/email/postmates-std-medium.woff) format(&#x27;woff&#x27;);
            }

            @font-face {
              font-family: &#x27;Postmates Std&#x27;;
              font-weight: 400;
              font-style: normal;
              src: local(&#x27;Postmates Std Regular&#x27;), url(https://s3-us-west-1.amazonaws.com/buyer-static.postmates.com/assets/email/postmates-std-regular.woff) format(&#x27;woff&#x27;);
            }
        </style>
<style media="screen and (max-width: 680px)">
            @media screen and (max-width: 680px) {
                .page-center {
                  padding-left: 0 !important;
                  padding-right: 0 !important;
                }
                
                .footer-center {
                  padding-left: 20px !important;
                  padding-right: 20px !important;
                }
            }
        </style>
</head>
<body style="background-color: #f4f4f5;">
<table cellpadding="0" cellspacing="0" style="width: 100%; height: 100%; background-color: #f4f4f5; text-align: center;">
<tbody><tr>
<td style="text-align: center;">
<table align="center" cellpadding="0" cellspacing="0" id="body" style="background-color: #fff; width: 100%; max-width: 720px; height: 100%;">
<tbody><tr>
<td>
<table align="center" cellpadding="0" cellspacing="0" class="page-center" style="text-align: left; padding-bottom: 88px; width: 100%; padding-left: 120px; padding-right: 120px;">
<tbody>
<tr>
<td colspan="3" style="padding-top: 72px; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #000000; font-family: ''Postmates Std'', ''Helvetica'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Roboto'', ''Oxygen'', ''Ubuntu'', ''Cantarell'', ''Fira Sans'', ''Droid Sans'', ''Helvetica Neue'', sans-serif; font-size: 38px; font-smoothing: always; font-style: normal; font-weight: 600; letter-spacing: -2.6px; line-height: 52px; mso-line-height-rule: exactly; text-decoration: none;">Recuperacion de contraseña</td>
</tr>
<tr>
<td style="padding-top: 48px; padding-bottom: 48px;">
<table cellpadding="0" cellspacing="0" style="width: 100%">
<tbody><tr>
<td style="width: 100%; height: 1px; max-height: 1px; background-color: #d9dbe0; opacity: 0.81"></td>
</tr>
</tbody></table>
</td>
</tr>
<tr>
<td style="-ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #9095a2; font-family: ''Postmates Std'', ''Helvetica'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Roboto'', ''Oxygen'', ''Ubuntu'', ''Cantarell'', ''Fira Sans'', ''Droid Sans'', ''Helvetica Neue'', sans-serif; font-size: 16px; font-smoothing: always; font-style: normal; font-weight: 400; letter-spacing: -0.18px; line-height: 24px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 100%;">
                                      Este correo es para recuperar tu contraseña {userName}.
                                    </td>
</tr>
<tr>
<td style="padding-top: 24px; -ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #9095a2; font-family: ''Postmates Std'', ''Helvetica'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Roboto'', ''Oxygen'', ''Ubuntu'', ''Cantarell'', ''Fira Sans'', ''Droid Sans'', ''Helvetica Neue'', sans-serif; font-size: 16px; font-smoothing: always; font-style: normal; font-weight: 400; letter-spacing: -0.18px; line-height: 24px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 100%;">
                                      Ingrese en el siguiente enlace para poder ingresar nueva contraseña.
                                    </td>
</tr>
<tr>
<td>
<a data-click-track-id="37" href="https://textelaniin.azurewebsites.net/test/pass/resetpwd?userName={link}&pwd=" style="margin-top: 36px; -ms-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; color: #ffffff; font-family: ''Postmates Std'', ''Helvetica'', -apple-system, BlinkMacSystemFont, ''Segoe UI'', ''Roboto'', ''Oxygen'', ''Ubuntu'', ''Cantarell'', ''Fira Sans'', ''Droid Sans'', ''Helvetica Neue'', sans-serif; font-size: 12px; font-smoothing: always; font-style: normal; font-weight: 600; letter-spacing: 0.7px; line-height: 48px; mso-line-height-rule: exactly; text-decoration: none; vertical-align: top; width: 220px; background-color: #00cc99; border-radius: 28px; display: block; text-align: center; text-transform: uppercase" target="_blank">
                                        Reinicio de Contraseña
                                      </a>
</td>
</tr>
</tbody></table>
</td>
</tr>
</tbody></table>
</body>','reset_pass',1)
;