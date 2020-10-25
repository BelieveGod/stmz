-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '语文');
INSERT INTO `subject` VALUES ('2', '英语');
INSERT INTO `subject` VALUES ('3', '数学');
INSERT INTO `subject` VALUES ('4', '政治');
INSERT INTO `subject` VALUES ('5', '地理');
INSERT INTO `subject` VALUES ('6', '历史');
INSERT INTO `subject` VALUES ('7', '物理');
INSERT INTO `subject` VALUES ('8', '化学');
INSERT INTO `subject` VALUES ('9', '生物');


-- ----------------------------
-- Records of tb_class
-- ----------------------------
INSERT INTO `tb_class` VALUES ('1', '1-1');
INSERT INTO `tb_class` VALUES ('2', '1-2');
INSERT INTO `tb_class` VALUES ('3', '1-3');
INSERT INTO `tb_class` VALUES ('4', '1-4');
INSERT INTO `tb_class` VALUES ('5', '2-1');
INSERT INTO `tb_class` VALUES ('6', '2-2');
INSERT INTO `tb_class` VALUES ('7', '2-3');
INSERT INTO `tb_class` VALUES ('8', '2-4');
INSERT INTO `tb_class` VALUES ('9', '3-1');
INSERT INTO `tb_class` VALUES ('10', '3-2');


-- ----------------------------
-- Records of tb_menu_item
-- ----------------------------
INSERT INTO `tb_menu_item` VALUES ('1', null, '课程管理', null, '/course/panel');
INSERT INTO `tb_menu_item` VALUES ('2', null, '教师管理', null, '/teacher/panel');
INSERT INTO `tb_menu_item` VALUES ('3', null, '我的信息', null, '/teacher/myInfo');
INSERT INTO `tb_menu_item` VALUES ('4', null, '分配账号', null, '/teacher/assign');


-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '管理员');
INSERT INTO `tb_role` VALUES ('2', '教师');


-- ----------------------------
-- Records of tb_role_rel_menu_item
-- ----------------------------
INSERT INTO `tb_role_rel_menu_item` VALUES ('1', '1');
INSERT INTO `tb_role_rel_menu_item` VALUES ('2', '1');
INSERT INTO `tb_role_rel_menu_item` VALUES ('3', '2');
INSERT INTO `tb_role_rel_menu_item` VALUES ('4', '1');


-- ----------------------------
-- Records of tb_teacher_rel_class
-- ----------------------------
INSERT INTO `tb_teacher_rel_class` VALUES ('1', '2');
INSERT INTO `tb_teacher_rel_class` VALUES ('4', '1');
INSERT INTO `tb_teacher_rel_class` VALUES ('6', '2');
INSERT INTO `tb_teacher_rel_class` VALUES ('7', '2');
INSERT INTO `tb_teacher_rel_class` VALUES ('8', '2');




-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'root', 'root');
INSERT INTO `tb_user` VALUES ('2', '123', 'lisi');
INSERT INTO `tb_user` VALUES ('3', '123', 'wangwu');



-- ----------------------------
-- Records of tb_user_rel_role
-- ----------------------------
INSERT INTO `tb_user_rel_role` VALUES ('1', '1');
INSERT INTO `tb_user_rel_role` VALUES ('2', '2');
INSERT INTO `tb_user_rel_role` VALUES ('2', '3');


-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '2020-10-01 21:56:08.000000', '行政', '我是一个老师', '本科', '张三', 'A-301', '13366669999', '2000', null, '历史', '1', null);
INSERT INTO `teacher` VALUES ('2', null, '行政', '编辑', '本科', '李四', 'A-301', '13366669999', '2000', null, '历史', '2', 'lisi');
INSERT INTO `teacher` VALUES ('4', null, '行政', '', '本科', '张三', 'A-301', '13366669999', '2000', null, '历史', '4', null);
INSERT INTO `teacher` VALUES ('6', '2020-10-09 00:00:00.000000', '行政', '<p>的方法 发到付 浮动</p><p>广发给广发</p>', '本科', '张三', 'A-301', '13366669999', '2000', null, '历史', '6', null);
INSERT INTO `teacher` VALUES ('7', null, '行政', null, '本科', '张三', 'A-301', '13366669999', '2000', null, '历史', '7', null);
INSERT INTO `teacher` VALUES ('9', '2020-10-08 00:00:00.000000', '行政', 'fdasf&nbsp;', '本科', '张三', 'A-301', '13366669999', '3233', null, '历史', '9', null);
INSERT INTO `teacher` VALUES ('10', null, '行政', '', '本科', '张三', 'A-301', '13366669999', '2000', null, '英语', '10', null);
INSERT INTO `teacher` VALUES ('11', null, '行政', null, '本科', '张三', 'A-301', '13366669999', '2000', null, '历史', '11', null);
INSERT INTO `teacher` VALUES ('12', null, '行政', null, '本科', '张三', 'A-301', '13366669999', '2000', null, '历史', '12', null);
INSERT INTO `teacher` VALUES ('22', '2020-10-15 00:00:00.000000', '行政', '', '本科', '王五', '', '', null, null, '语文', '13', 'wangwu');
INSERT INTO `teacher` VALUES ('23', '2020-10-12 00:00:00.000000', '教学', '', '本科', 'wode', 'b-393', '13356567788', '1323', null, '历史', '44', null);