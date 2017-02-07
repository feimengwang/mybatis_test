CREATE TABLE `student` (
  `studId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`studId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
