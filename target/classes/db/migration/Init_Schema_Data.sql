drop database if exists vncare;

create database vncare
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

use vncare;

create table dm_taikhoan (
	id int not null auto_increment,
    username varchar(50) not null,
    password varchar(60) not null,	
    sdt varchar(20) not null,
    hoten varchar(50),
    
    primary key(id),
    unique(username,sdt)
);

create table dm_vaitro (
	id int not null auto_increment,
    ten varchar(50) not null,
    
    primary key(id)
);

create table dm_taikhoan_vaitro(
	taikhoanid int not null,
    vaitroid int not null,
    
    unique(taikhoanid),
    foreign key(taikhoanid) references dm_taikhoan(id),
    foreign key(vaitroid) references dm_vaitro(id)
);

create table dm_benhnhan(
	id int not null auto_increment,
    ten varchar(50) not null,
    ngaysinh date not null,
    gioitinh boolean, 		
	cmnd varchar(20),
    noicap varchar(20),
    ngaycap date,
    bhyt varchar(20),
	diachi varchar(500) not null,
	anhdaidien text not null,
    anhbhyt text,
    cmtnd_truoc text,
    cmtnd_sau text,
    taikhoanid int(11) null default null,
    
    unique(taikhoanid),
    primary key (id),
    foreign key (taikhoanid) references dm_taikhoan(id)
);


create table dm_quanhe(
	id int not null auto_increment,
	idchinh int not null,
    idphu int not null,
    loaiquanhe int not null default 0,
    
    unique(id),
    foreign key (idchinh) references dm_benhnhan(id),
    foreign key (idphu) references dm_benhnhan(id)
);


create table dm_tinh(
	id int not null auto_increment,
    ten varchar(30) not null,
    
    primary key(id)
);

create table dm_cosoyte(
	id int not null auto_increment,
    ten varchar(50) not null,
    tinhid int not null,
    
    primary key(id),	
    foreign key (tinhid) references dm_tinh(id)
);


create table dm_khoa(
	id int not null auto_increment,
    ten varchar(50) not null,
    cosoyteid int not null,
    
    primary key(id),
    foreign key(cosoyteid) references dm_cosoyte(id)
);

create table dm_bacsi(
	id int not null auto_increment,
    ten varchar(50) not null,
    chuyenkhoa varchar(50) not null,
    trinhdo varchar(50),
    mota varchar(200),
    khoaid int not null,
    taikhoanid int not null,
    
    unique(taikhoanid),
    primary key(id),
    foreign key (khoaid) references dm_khoa(id),
    foreign key (taikhoanid) references dm_taikhoan(id)
);


create table dm_benh(
	id int not null auto_increment,
    ten varchar(100) not null,		
    mabenh varchar(20),
    mota varchar(500) not null,
    
    primary key (id)
);

create table dm_loaikham(
	id int not null auto_increment,
    ten varchar(50) not null,		
    mota varchar(500),
    
    primary key (id)
);


create table kb_dangkykham(
	id int not null auto_increment,
    thoigiandk datetime not null,
    thoigiankham datetime not null,
    trangthaikham boolean not null,
    noidungkham varchar(100),
    benhchinhid int,
    benhphu varchar(500),
    mota varchar(500),
    benhnhanid int not null,
    bacsiid int not null,
    loaikhamid int not null,
    
    primary key(id),
    foreign key (benhnhanid) references dm_benhnhan(id),
    foreign key (bacsiid) references dm_bacsi(id),
    foreign key (benhchinhid) references dm_benh(id),
    foreign key (loaikhamid) references dm_loaikham(id)
);


create table dm_thuoc(
	id int not null auto_increment,
    ten varchar(50) not null,
    mota varchar(100),
    
    primary key (id),
    unique(ten)
);


create table dm_donvitinh(
    id int not null auto_increment,
    ten varchar(20) not null,
    chitiet varchar(100),
    
    primary key (id)
);


create table kb_donthuoc(
	id int not null auto_increment,
	dangkykhamid int not null,
    thuocid int not null,
    donvitinhid int not null,
    soluong decimal(7,1) not null,
    huongdan varchar(100),
    
    unique (id),
    foreign key (dangkykhamid) references kb_dangkykham(id),
    foreign key (thuocid) references dm_thuoc(id),
    foreign key (donvitinhid) references dm_donvitinh(id)
);