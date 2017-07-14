@Echo Off
Echo open 47.93.47.178 21 >ftp.up
Echo alin>>ftp.up
Echo 698970s>>ftp.up
Echo Cd /data/wwwroot >>ftp.up
Echo binary>>ftp.up
Echo put "E:\workspace2\task2\logs\task2.log">>ftp.up
Echo bye>>ftp.up
FTP -s:ftp.up
del ftp.up /q
pause