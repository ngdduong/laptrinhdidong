
-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `registerdemo`
--
-- Tạo: Th4 12, 2022 lúc 07:43 AM
-- Cập nhật lần cuối: Th4 14, 2022 lúc 03:45 AM
--

DROP TABLE IF EXISTS `registerdemo`;
CREATE TABLE IF NOT EXISTS `registerdemo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `hobby` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `registerdemo`:
--

--
-- Đang đổ dữ liệu cho bảng `registerdemo`
--

INSERT INTO `registerdemo` (`id`, `name`, `hobby`, `username`, `password`) VALUES
(1, 'lequan', 'da bong', 'quan', '123'),
(2, 'lethe', 'cau long', 'lethe', '123'),
(3, 'khang', 'xem phim', 'khang', '123');
