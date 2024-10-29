package util;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import model.LichSuChamSoc1D3;
import model.LichSuChamSocEN;

import model.LichSuChamSocHP;
import model.LichSuChamSocVH;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportToExcel {

    public static void exportHP(String tenCD, List<LichSuChamSocHP> users, List<String> item, String duongDanLuu) {
        try {
            // Tạo Workbook và Sheet mới
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(tenCD);

            // Định dạng cho các ô trong bảng
            CellStyle defaultCellStyle = workbook.createCellStyle();
            defaultCellStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 12); // độ lớn của font
            font.setFontName("Arial"); // tên font
            defaultCellStyle.setFont(font);

            // Định dạng cho tiền tệ
            CellStyle currencyStyle = workbook.createCellStyle();
            currencyStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00"));

            // Định dạng cho tiêu đề của bảng
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
            Font headerFont = workbook.createFont();
            headerFont.setFontHeightInPoints((short) 12); // độ lớn của font
            headerFont.setFontName("Arial"); // tên font
            headerFont.setBold(true); // in đậm
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex()); // màu nền
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Tạo header cho Sheet
            Row headerRow = sheet.createRow(0);
            headerRow.setHeight((short) 400);
            headerRow.setRowStyle(headerStyle);
            headerRow.createCell(0).setCellValue("STT");
            headerRow.getCell(0).setCellStyle(headerStyle);

            int colNum = 1;
            for (String itemName : item) {
                headerRow.createCell(colNum).setCellValue(itemName);
                if (!itemName.equals(" ")) {
                    headerRow.getCell(colNum).setCellStyle(headerStyle);
                }
                colNum++;
            }

            // Ghi dữ liệu vào Sheet
            int rowNum = 1;
            String mssv = "";
            for (LichSuChamSocHP dg : users) {
                String mssvCheck = dg.getMssv();
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rowNum - 1);
                row.getCell(0).setCellStyle(currencyStyle);
                colNum = 1;

               if (mssv.equalsIgnoreCase(mssvCheck)) {
                Row previousRow = sheet.getRow(rowNum - 2);
                Cell previousCell = previousRow.getCell(previousRow.getLastCellNum() - 1);
                CellStyle wrapCellStyle = workbook.createCellStyle();
                wrapCellStyle.cloneStyleFrom(previousCell.getCellStyle());
                wrapCellStyle.setWrapText(true);
                previousCell.setCellStyle(wrapCellStyle);
                String previousValue = previousCell.getStringCellValue();
                previousCell.setCellValue(previousValue + "\n" + "- "+dg.getDienGiaiCT());
                rowNum--;
            } else {
                    for (String itemName : item) {
                        switch (itemName) {
                            case "Học kỳ":
                                row.createCell(colNum).setCellValue(dg.getHocKi().getMaHocKi());
                                break;
                            case "Tên chiến dịch":
                                row.createCell(colNum).setCellValue(dg.getChienDich().getTenChienDich());
                                break;
                            case "MSSV":
                                row.createCell(colNum).setCellValue(dg.getMssv());
                                break;
                            case "Chuyên ngành":
                                row.createCell(colNum).setCellValue(dg.getChuyenNganh());
                                break;
                            case "Kỳ học":
                                row.createCell(colNum).setCellValue(dg.getKyHoc());
                                break;
                            case "Trạng thái":
                                row.createCell(colNum).setCellValue(dg.isTrangThaiHP());
                                break;
                            case "Người chăm sóc":
                                row.createCell(colNum).setCellValue(dg.getNhanSu().getMans());
                                break;
                            case "Thời gian chăm sóc":
                                row.createCell(colNum).setCellValue(dg.getThoiGianCS().toString());
                                break;
                            case "Lý do ghi nhận":
                                row.createCell(colNum).setCellValue(dg.getLyDoGhiNhan());
                                break;
                            case "Nguyện vọng của SV/PH":
                                row.createCell(colNum).setCellValue(dg.getNguyenVongSvPh());
                                break;
                            case "Đối tượng":
                                row.createCell(colNum).setCellValue(dg.getDoiTuong());
                                break;
                            case "Phân loại nguy cơ":
                                row.createCell(colNum).setCellValue(dg.getPhanLoaiNguyCo());
                                break;
                            case "Diễn giải chi tiết":
                                row.createCell(colNum).setCellValue(dg.getDienGiaiCT());
                                break;
                            default:
                                break;
                        }
                        row.getCell(colNum).setCellStyle(defaultCellStyle);
                        colNum++;
                    }
                }
                mssv = mssvCheck;
            }

            // Auto-size columns
            for (int i = 0; i < colNum; i++) {
                sheet.autoSizeColumn(i);
            }

            // Ghi dữ liệu vào file
            FileOutputStream outputStream = new FileOutputStream(duongDanLuu + ".xlsx");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);

            // Đóng các luồng
            bufferedOutputStream.close();
            outputStream.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//      public static void exportVH(String tenCD, List<LichSuChamSocVH> users, List<String> item, String duongDanLuu) {
//        try {
//            System.out.println("util.ExportToExcel.exportVH()");
//            // Tạo Workbook và Sheet mới
//            Workbook workbook = new XSSFWorkbook();
//            Sheet sheet = workbook.createSheet(tenCD);
//            // Định dạng cho các ô trong bảng
//            CellStyle defaultCellStyle = workbook.createCellStyle();
//            defaultCellStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
//            Font font = workbook.createFont();
//            font.setFontHeightInPoints((short) 12); // độ lớn của font
//            font.setFontName("Arial"); // tên font
//            defaultCellStyle.setFont(font);
//
//            // Định dạng cho tiền tệ
//            CellStyle currencyStyle = workbook.createCellStyle();
//            currencyStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00"));
//
//            // Định dạng cho tiêu đề của bảng
//            CellStyle headerStyle = workbook.createCellStyle();
//            headerStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
//            Font headerFont = workbook.createFont();
//            headerFont.setFontHeightInPoints((short) 12); // độ lớn của font
//            headerFont.setFontName("Arial"); // tên font
//            headerFont.setBold(true); // in đậm
//            headerStyle.setFont(headerFont);
//            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex()); // màu nền
//            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//
//            // Tạo header cho Sheet
//            Row headerRow = sheet.createRow(0);
//            headerRow.setHeight((short) 400);
//            headerRow.setRowStyle(headerStyle);
//            headerRow.createCell(0).setCellValue("STT");
//            headerRow.getCell(0).setCellStyle(headerStyle);
//            int colNum = 1;
//            for (String itemName : item) {
//                headerRow.createCell(colNum).setCellValue(itemName);
//
//                if (!headerRow.getCell(colNum).equals(" ")) {
//                    headerRow.getCell(colNum).setCellStyle(headerStyle);
//                }
//                colNum++;
//            }
//
//            // Ghi dữ liệu vào Sheet
//            int rowNum = 1;
//            for (LichSuChamSocVH dg : users) {
//                System.out.println(rowNum);
//                Row row = sheet.createRow(rowNum++);
//                row.createCell(0).setCellStyle(currencyStyle);
//                row.createCell(0).setCellValue(rowNum - 1);
//                colNum = 1;
//                for (String itemName : item) {
//                   switch (itemName) {
//                        case "Học kỳ":
//                            row.createCell(colNum).setCellValue(dg.getHocKi().getMaHocKi());
//                            break;
//                        case "Tên chiến dịch":
//                            row.createCell(colNum).setCellValue(dg.getChienDich().getTenChienDich());
//                            break;
//                        case "MSSV":
//                            row.createCell(colNum).setCellValue(dg.getMssv());
//                            break;
//                        case "Chuyên Ngành":
//                            row.createCell(colNum).setCellValue(dg.getChuyenNganh());
//                            break;
//                        case "Kỳ học":
//                            row.createCell(colNum).setCellValue(dg.getKyHoc());
//                            break;
//                        case "Mã môn":
//                            row.createCell(colNum).setCellValue(dg.getMaMon());
//                            break;  
//                        case "Người chăm sóc":
//                            row.createCell(colNum).setCellValue(dg.getNhanSu().getMans());
//                            break;
//                        case "Thời gian chăm sóc":
//                            row.createCell(colNum).setCellValue(dg.getThoiGianCS());
//                            break;
//                        case "Lý do ghi nhận":
//                            row.createCell(colNum).setCellValue(dg.getLyDoGhiNhan());
//                            break;
//                        case "Nguyện vọng của SV/PH":
//                            row.createCell(colNum).setCellValue(dg.getNguyenVongSvPh());
//                            break;
//                        case "Đối tượng":
//                            row.createCell(colNum).setCellValue(dg.getDoiTuong());
//                            break;
//                        case "Phân loại nguy cơ":
//                            row.createCell(colNum).setCellValue(dg.getPhanLoaiNguyCo());
//                            break;
//                        case "Diễn giải chi tiết":
//                            row.createCell(colNum).setCellValue(dg.getDienGiaiCT());
//                            break;
//                        default:
//                            break;
//                    }
////	                row.getCell(colNum).setCellStyle(defaultCellStyle);
//                    sheet.autoSizeColumn(colNum);
//                    colNum++;
//                }
//                //	count++;
//                //progressBar.updateProgress(count);
//            }
//            FileOutputStream outputStream;
//            outputStream = new FileOutputStream(duongDanLuu + ".xlsx");
//            workbook.write(outputStream);
//            workbook.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
   public static void exportVH(String tenCD, List<LichSuChamSocVH> users, List<String> item, String duongDanLuu) {
    try {
        // Tạo Workbook và Sheet mới
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(tenCD);

        // Định dạng cho các ô trong bảng
        CellStyle defaultCellStyle = workbook.createCellStyle();
        defaultCellStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 12); // độ lớn của font
        font.setFontName("Arial"); // tên font
        defaultCellStyle.setFont(font);

        // Định dạng cho tiền tệ
        CellStyle currencyStyle = workbook.createCellStyle();
        currencyStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00"));

        // Định dạng cho tiêu đề của bảng
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12); // độ lớn của font
        headerFont.setFontName("Arial"); // tên font
        headerFont.setBold(true); // in đậm
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex()); // màu nền
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Tạo header cho Sheet
        Row headerRow = sheet.createRow(0);
        headerRow.setHeight((short) 400);
        headerRow.setRowStyle(headerStyle);
        headerRow.createCell(0).setCellValue("STT");
        headerRow.getCell(0).setCellStyle(headerStyle);
        int colNum = 1;
        for (String itemName : item) {
       
            headerRow.createCell(colNum).setCellValue(itemName);
            if (!itemName.equals(" ")) {
                headerRow.getCell(colNum).setCellStyle(headerStyle);
            }
            colNum++;
        }

        String mssv = "";

        // Ghi dữ liệu vào Sheet
        int rowNum = 1;
        for (LichSuChamSocVH dg : users) {
            String mssvCheck = dg.getMssv();
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellStyle(currencyStyle);
            row.createCell(0).setCellValue(rowNum - 1);
            colNum = 1;
            if (mssv.equalsIgnoreCase(mssvCheck)) {
                Row previousRow = sheet.getRow(rowNum - 2);
                Cell previousCell = previousRow.getCell(previousRow.getLastCellNum() - 1);
                CellStyle wrapCellStyle = workbook.createCellStyle();
                wrapCellStyle.cloneStyleFrom(previousCell.getCellStyle());
                wrapCellStyle.setWrapText(true);
                previousCell.setCellStyle(wrapCellStyle);
                String previousValue = previousCell.getStringCellValue();
                previousCell.setCellValue(previousValue + "\n" + "- "+dg.getDienGiaiCT());
                rowNum--;
            } else {
                for (String itemName : item) {
                    switch (itemName) {
                        case "Học kỳ":
                            row.createCell(colNum).setCellValue(dg.getHocKi().getMaHocKi());
                            break;
                        case "Tên chiến dịch":
                            row.createCell(colNum).setCellValue(dg.getChienDich().getTenChienDich());
                            break;
                        case "MSSV":
                            row.createCell(colNum).setCellValue(dg.getMssv());
                            break;
                        case "Chuyên Ngành":
                            row.createCell(colNum).setCellValue(dg.getChuyenNganh());
                            break;
                        case "Kỳ học":
                            row.createCell(colNum).setCellValue(dg.getKyHoc());
                            break;
                        case "Mã môn":
                            row.createCell(colNum).setCellValue(dg.getMaMon());
                            break;
                        case "Người chăm sóc":
                            row.createCell(colNum).setCellValue(dg.getNhanSu().getMans());
                            break;
                        case "Thời gian chăm sóc":
                            row.createCell(colNum).setCellValue(dg.getThoiGianCS().toString());
                            break;
                        case "Lý do ghi nhận":
                            row.createCell(colNum).setCellValue(dg.getLyDoGhiNhan());
                            break;
                        case "Nguyện vọng của SV/PH":
                            row.createCell(colNum).setCellValue(dg.getNguyenVongSvPh());
                            break;
                        case "Đối tượng":
                            row.createCell(colNum).setCellValue(dg.getDoiTuong());
                            break;
                        case "Phân loại nguy cơ":
                            row.createCell(colNum).setCellValue(dg.getPhanLoaiNguyCo());
                            break;
                        case "Diễn giải chi tiết":
                            row.createCell(colNum).setCellValue("- "+dg.getDienGiaiCT());
                            break;
                        default:
                            break;
                    }
                    colNum++;
                }
            }
            mssv = mssvCheck;
        }

//        // Auto-size columns

for (int i = 0; i < rowNum; i++) {
        sheet.autoSizeColumn(i); // Sử dụng auto-size cho các cột khác
}

        // Ghi dữ liệu vào file
        FileOutputStream outputStream = new FileOutputStream(duongDanLuu + ".xlsx");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        workbook.write(bufferedOutputStream);

        // Đóng các luồng
        bufferedOutputStream.close();
        outputStream.close();
        workbook.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public static void exportEN(String tenCD, List<LichSuChamSocEN> users, List<String> item, String duongDanLuu) {
        try {
            System.out.println("util.ExportToExcel.exportVH()");

            // Tạo Workbook và Sheet mới
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(tenCD);

            // Định dạng cho các ô trong bảng
            CellStyle defaultCellStyle = workbook.createCellStyle();
            defaultCellStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 12); // độ lớn của font
            font.setFontName("Arial"); // tên font
            defaultCellStyle.setFont(font);

            // Định dạng cho tiền tệ
            CellStyle currencyStyle = workbook.createCellStyle();
            currencyStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00"));

            // Định dạng cho tiêu đề của bảng
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
            Font headerFont = workbook.createFont();
            headerFont.setFontHeightInPoints((short) 12); // độ lớn của font
            headerFont.setFontName("Arial"); // tên font
            headerFont.setBold(true); // in đậm
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex()); // màu nền
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Tạo header cho Sheet
            Row headerRow = sheet.createRow(0);
            headerRow.setHeight((short) 400);
            headerRow.setRowStyle(headerStyle);
            headerRow.createCell(0).setCellValue("STT");
            headerRow.getCell(0).setCellStyle(headerStyle);
            int colNum = 1;
            for (String itemName : item) {
                headerRow.createCell(colNum).setCellValue(itemName);
                if (!headerRow.getCell(colNum).equals(" ")) {
                    headerRow.getCell(colNum).setCellStyle(headerStyle);
                }
                colNum++;
            }

            String mssv = "";
            // Ghi dữ liệu vào Sheet
            int rowNum = 1;
            for (LichSuChamSocEN dg : users) {
                 String mssvCheck = dg.getMssv();
                System.out.println(rowNum);
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellStyle(currencyStyle);
                row.createCell(0).setCellValue(rowNum - 1);
                colNum = 1;
                 if (mssv.equalsIgnoreCase(mssvCheck)) {
                Row previousRow = sheet.getRow(rowNum - 2);
                Cell previousCell = previousRow.getCell(previousRow.getLastCellNum() - 1);
                CellStyle wrapCellStyle = workbook.createCellStyle();
                wrapCellStyle.cloneStyleFrom(previousCell.getCellStyle());
                wrapCellStyle.setWrapText(true);
                previousCell.setCellStyle(wrapCellStyle);
                String previousValue = previousCell.getStringCellValue();
                previousCell.setCellValue(previousValue + "\n" + "- "+dg.getDienGiaiCT());
                rowNum--;
            } else{
                for (String itemName : item) {
                    switch (itemName) {
                        case "Học kỳ":
                            row.createCell(colNum).setCellValue(dg.getHocKi().getMaHocKi());
                            break;
                        case "Tên chiến dịch":
                            row.createCell(colNum).setCellValue(dg.getChienDich().getTenChienDich());
                            break;
                        case "MSSV":
                            row.createCell(colNum).setCellValue(dg.getMssv());
                            break;
                        case "Chuyên Ngành":
                            row.createCell(colNum).setCellValue(dg.getChuyenNganh());
                            break;
                        case "Kỳ học":
                            row.createCell(colNum).setCellValue(dg.getKyHoc());
                            break;
                        case "Mã môn":
                            row.createCell(colNum).setCellValue(dg.getMaMon());
                            break;
                        case "Người chăm sóc":
                            row.createCell(colNum).setCellValue(dg.getNhanSu().getMans());
                            break;
                        case "Thời gian chăm sóc":
                            row.createCell(colNum).setCellValue(dg.getThoiGianCS().toString());
                            break;
                        case "Lý do ghi nhận":
                            row.createCell(colNum).setCellValue(dg.getLyDoGhiNhan());
                            break;
                        case "Nguyện vọng của SV/PH":
                            row.createCell(colNum).setCellValue(dg.getNguyenVongSvPh());
                            break;
                        case "Đối tượng":
                            row.createCell(colNum).setCellValue(dg.getDoiTuong());
                            break;
                        case "Phân loại nguy cơ":
                            row.createCell(colNum).setCellValue(dg.getPhanLoaiNguyCo());
                            break;
                        case "Diễn giải chi tiết":
                            row.createCell(colNum).setCellValue(dg.getDienGiaiCT());
                            break;
                        default:
                            break;
                    }
                    colNum++;
                }
            }
             mssv = mssvCheck;
            }

            // Auto-size columns
          
            for (int i = 0; i < colNum; i++) {
                sheet.autoSizeColumn(i);
            }

            // Ghi dữ liệu vào file
            FileOutputStream outputStream = new FileOutputStream(duongDanLuu + ".xlsx");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);

            // Đóng các luồng
            bufferedOutputStream.close();
            outputStream.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void export1D3(String tenCD, List<LichSuChamSoc1D3> users, List<String> item, String duongDanLuu) {
        try {
            // Tạo Workbook và Sheet mới
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(tenCD);

            // Định dạng cho các ô trong bảng
            CellStyle defaultCellStyle = workbook.createCellStyle();
            defaultCellStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 12); // độ lớn của font
            font.setFontName("Arial"); // tên font
            defaultCellStyle.setFont(font);

            // Định dạng cho tiền tệ
            CellStyle currencyStyle = workbook.createCellStyle();
            currencyStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00"));

            // Định dạng cho tiêu đề của bảng
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.CENTER); // căn giữa nội dung
            Font headerFont = workbook.createFont();
            headerFont.setFontHeightInPoints((short) 12); // độ lớn của font
            headerFont.setFontName("Arial"); // tên font
            headerFont.setBold(true); // in đậm
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex()); // màu nền
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Tạo header cho Sheet
            Row headerRow = sheet.createRow(0);
            headerRow.setHeight((short) 400);
            headerRow.setRowStyle(headerStyle);
            headerRow.createCell(0).setCellValue("STT");
            headerRow.getCell(0).setCellStyle(headerStyle);
            int colNum = 1;
            for (String itemName : item) {
                headerRow.createCell(colNum).setCellValue(itemName);
                if (!headerRow.getCell(colNum).equals(" ")) {
                    headerRow.getCell(colNum).setCellStyle(headerStyle);
                }
                colNum++;
            }
            String mssv = "";
            // Ghi dữ liệu vào Sheet
            int rowNum = 1;
            for (LichSuChamSoc1D3 dg : users) {
                String mssvCheck = dg.getMSSV();
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellStyle(currencyStyle);
                row.createCell(0).setCellValue(rowNum - 1);
                colNum = 1;
                if (mssv.equalsIgnoreCase(mssvCheck)) {
                Row previousRow = sheet.getRow(rowNum - 2);
                Cell previousCell = previousRow.getCell(previousRow.getLastCellNum() - 1);
                CellStyle wrapCellStyle = workbook.createCellStyle();
                wrapCellStyle.cloneStyleFrom(previousCell.getCellStyle());
                wrapCellStyle.setWrapText(true);
                previousCell.setCellStyle(wrapCellStyle);
                String previousValue = previousCell.getStringCellValue();
                previousCell.setCellValue(previousValue + "\n" + "- "+dg.getDienGiaiCT());
                rowNum--;
            }else{
                for (String itemName : item) {
                    switch (itemName) {
                        case "Học kỳ":
                            row.createCell(colNum).setCellValue(dg.getHocKi().getMaHocKi());
                            break;
                        case "Tên chiến dịch":
                            row.createCell(colNum).setCellValue(dg.getChienDich().getTenChienDich());
                            break;
                        case "MSSV":
                            row.createCell(colNum).setCellValue(dg.getMSSV());
                            break;
                        case "Ngành":
                            row.createCell(colNum).setCellValue(dg.getNganh());
                            break;
                        case "Chuyên ngành":
                            row.createCell(colNum).setCellValue(dg.getChuyenNganh());
                            break;
                        case "Mã môn học":
                            row.createCell(colNum).setCellValue(dg.getMaMon());
                            break;
                        case "Tên môn học":
                            row.createCell(colNum).setCellValue(dg.getTenMonHoc());
                            break;
                        case "Lớp":
                            row.createCell(colNum).setCellValue(dg.getLop());
                            break;
                        // lịch sử chăm sóc 1d3 chưa có block
                        case "Block":
                            row.createCell(colNum).setCellValue(dg.getBlock());
                            break;
                        case "Ngày bắt đầu lớp":
                            row.createCell(colNum).setCellValue(dg.getNgayBatDauLop());
                            break;
                        case "Ngày kết thúc lớp ":
                            row.createCell(colNum).setCellValue(dg.getNgayKetThucLop());
                            break;
                        case "Tên GV":
                            row.createCell(colNum).setCellValue(dg.getTenGV());
                            break;
                        case "Tiêu chí":
                            row.createCell(colNum).setCellValue(dg.getTieuChi());
                            break;
                        case "Nhận xét":
                            row.createCell(colNum).setCellValue(dg.getNhanXet());
                            break;
                        case "Thời gian":
                            row.createCell(colNum).setCellValue(dg.getThoiGian());
                            break;
                        case "Ghi chú":
                            row.createCell(colNum).setCellValue(dg.getGhiChu());
                            break;
                        case "Nhận xét chung":
                            row.createCell(colNum).setCellValue(dg.getNhanXetChung());
                            break;
                        case "Người chăm sóc":
                            row.createCell(colNum).setCellValue(dg.getNhanSu().getMans());
                            break;
                        case "Thời gian chăm sóc":
                            row.createCell(colNum).setCellValue(dg.getThoiGianCS().toString());
                            break;
                        case "Lý do ghi nhận":
                            row.createCell(colNum).setCellValue(dg.getLyDoGhiNhan());
                            break;
                        case "Nguyện vọng của SV/PH":
                            row.createCell(colNum).setCellValue(dg.getNguyenVongSvPh());
                            break;
                        case "Đối tượng":
                            row.createCell(colNum).setCellValue(dg.getDoiTuong());
                            break;
                        case "Phân loại nguy cơ":
                            row.createCell(colNum).setCellValue(dg.getPhanLoaiNguyCo());
                            break;
                        case "Diễn giải chi tiết":
                            row.createCell(colNum).setCellValue(dg.getDienGiaiCT());
                            break;
                        default:
                            break;
                    }
                    colNum++;
                }
            }
                  mssv = mssvCheck;
            }

            // Auto-size columns
            for (int i = 0; i < colNum; i++) {
                sheet.autoSizeColumn(i);
            }

            // Ghi dữ liệu vào file
            FileOutputStream outputStream = new FileOutputStream(duongDanLuu + ".xlsx");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);

            // Đóng các luồng
            bufferedOutputStream.close();
            outputStream.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
