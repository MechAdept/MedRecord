DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `visit`;
DROP TABLE IF EXISTS `health`;
DROP TABLE IF EXISTS `ticket`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `role` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `visit` (
                         `id` int(11) NOT NULL,
                         `ticket` int(11) DEFAULT NULL,
                         `patient` int(11) DEFAULT NULL,
                         `doctor` int(11) DEFAULT NULL,
                         `datetime` datetime DEFAULT NULL,
                         `complaint` text,
                         `examination` text,
                         `diagnosis` text,
                         `treatment` text,
                         PRIMARY KEY (`id`),
                         KEY `fk_visit_patient.id_idx` (`patient`),
                         KEY `fk_visit_doctor.id_idx` (`doctor`),
                         CONSTRAINT `fk_visit_doctor.id` FOREIGN KEY (`doctor`) REFERENCES `user` (`id`),
                         CONSTRAINT `fk_visit_patient.id` FOREIGN KEY (`patient`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `health` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `patient` int(11) DEFAULT NULL,
                          `photo` varchar(500) DEFAULT NULL,
                          `birth` date DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `patient_id_UNIQUE` (`patient`),
                          CONSTRAINT `fk_health_patient.id` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
                          `id` int(11) NOT NULL,
                          `patient` int(11) DEFAULT NULL,
                          `doctor` int(11) DEFAULT NULL,
                          `datetime` datetime DEFAULT NULL,
                          `attendance` tinyint(4) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `fk_ticket_patient.id_idx` (`patient`),
                          KEY `fk_ticket_doctor.id_idx` (`doctor`),
                          CONSTRAINT `fk_ticket_doctor.id` FOREIGN KEY (`doctor`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                          CONSTRAINT `fk_ticket_patient.id` FOREIGN KEY (`patient`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
                             `user_id` int(11) NOT NULL,
                             `role_id` int(11) NOT NULL,
                             PRIMARY KEY (`user_id`,`role_id`),
                             KEY `fk_user_role_roleid_idx` (`role_id`),
                             CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                             CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;