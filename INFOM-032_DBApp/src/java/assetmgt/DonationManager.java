package assetmgt;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;

public class DonationManager {
    
    private int donation_id;
    private String donorName;
    private String donationFormFile;
    private Date donationDate;
    private int acceptHoid;
    private String acceptPosition;
    private Date acceptElectionDate;
    private int approvalHoid;
    private String approvalPosition;
    private Date approvalElectionDate;

    public DonationManager() {}
    
    public int record_donation() {

        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(donation_id) + 1 AS newID FROM asset_donations");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                donation_id = rst.getInt("newID");
            }
            // Prepare SQL statement to insert new donation record
            pstmt = conn.prepareStatement("INSERT INTO asset_donations (donation_id, donor_completename, donation_formfile, date_donation, accept_hoid, accept_position, accept_electiondate, isdeleted) VALUES (?, ?, ?, ?, ?, ?, ?, 0)");
            pstmt.setInt(1, this.donation_id);
            pstmt.setString(2, this.donorName);
            pstmt.setString(3, this.donationFormFile);
            pstmt.setDate(4, new java.sql.Date(this.donationDate.getTime()));
            pstmt.setInt(5, this.acceptHoid);
            pstmt.setString(6, this.acceptPosition);
            pstmt.setDate(7, new java.sql.Date(this.acceptElectionDate.getTime()));

            // Execute SQL statement
            pstmt.executeUpdate();

            // Clean up resources
            pstmt.close();
            conn.close();

            // Return 1 for success
            return 1;

        } catch (SQLException e) {
            // Print error message and return 0 for failure
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int update_donation() {
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");

            // Prepare SQL statement to update existing donation record
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_donations SET donor_completename=?, donation_formfile=?, date_donation=?, accept_hoid=?, accept_position=?, accept_electiondate=? WHERE donation_id=?");
            pstmt.setString(1, this.donorName);
            pstmt.setString(2, this.donationFormFile);
            pstmt.setDate(3, new java.sql.Date(this.donationDate.getTime()));
            pstmt.setInt(4, this.acceptHoid);
            pstmt.setString(5, this.acceptPosition);
            pstmt.setDate(6, new java.sql.Date(this.acceptElectionDate.getTime()));
            pstmt.setInt(7, this.donation_id);

            // Execute SQL statement
            int rowsAffected = pstmt.executeUpdate();

            // Clean up resources
            pstmt.close();
            conn.close();

            // Return number of rows affected by update
            return rowsAffected;

        } catch (SQLException e) {
            // Print error message and return 0 for failure
            System.out.println(e.getMessage());
            return 0;
        }
    }

    
    public int getDonationId() {
        return donation_id;
    }
        

    public void setDonation(DonationManager donation) {      
        this.donation_id = donation.getDonationId();
        this.donorName = donation.getDonorName();
        this.donationFormFile = donation.getDonationFormFile();
        this.donationDate = donation.getDonationDate();
        this.acceptHoid = donation.getAcceptHoid();
        this.acceptPosition = donation.getAcceptPosition();
        this.acceptElectionDate = donation.getAcceptElectionDate();
        this.approvalHoid = donation.getApprovalHoid();
        this.approvalPosition = donation.getApprovalPosition();
        this.approvalElectionDate = donation.getApprovalElectionDate();
    }
    
    public void setDonationId(int donationId) {
        this.donation_id = donationId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonationFormFile() {
        return donationFormFile;
    }

    public void setDonationFormFile(String donationFormFile) {
        this.donationFormFile = donationFormFile;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public int getAcceptHoid() {
        return acceptHoid;
    }

    public void setAcceptHoid(int acceptHoid) {
        this.acceptHoid = acceptHoid;
    }

    public String getAcceptPosition() {
        return acceptPosition;
    }

    public void setAcceptPosition(String acceptPosition) {
        this.acceptPosition = acceptPosition;
    }

    public Date getAcceptElectionDate() {
        return acceptElectionDate;
    }

    public void setAcceptElectionDate(Date acceptElectionDate) {
        this.acceptElectionDate = acceptElectionDate;
    }
    
    public int getApprovalHoid() {
        return approvalHoid;
    }

    public void setApprovalHoid(int approvalHoid) {
        this.approvalHoid = approvalHoid;
    }

    public String getApprovalPosition() {
        return approvalPosition;
    }

    public void setApprovalPosition(String approvalPosition) {
        this.approvalPosition = approvalPosition;
    }

    public Date getApprovalElectionDate() {
        return approvalElectionDate;
    }

    public void setApprovalElectionDate(Date approvalElectionDate) {
        this.approvalElectionDate = approvalElectionDate;
    }
    
    public ArrayList<Integer> getDonationIds() {
        ArrayList<Integer> donationIds = new ArrayList<>();
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            // Execute SQL query to retrieve donation IDs
            PreparedStatement pstmt = conn.prepareStatement("SELECT donation_id FROM asset_donations ORDER BY donation_id");
            ResultSet rst = pstmt.executeQuery();
            
            // Iterate through results and add to ArrayList
            while (rst.next()) {
                int donationId = rst.getInt("donation_id");
                donationIds.add(donationId);
            }

            // Clean up resources
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            // Print error message
            System.out.println(e.getMessage());
        }

        return donationIds;
    }

    public ArrayList<String> getDistinctDonorNames() {
        ArrayList<String> donorNames = new ArrayList<>();
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");

            // Execute SQL query to retrieve distinct donor names
            PreparedStatement pstmt = conn.prepareStatement("SELECT DISTINCT donorname FROM donors ORDER BY donorname");
            ResultSet rst = pstmt.executeQuery();

            // Iterate through results and add to ArrayList
            while (rst.next()) {
                String donorName = rst.getString("donorname");
                donorNames.add(donorName);
            }

            // Clean up resources
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            // Print error message
            System.out.println(e.getMessage());
        }

        return donorNames;
    }

    public ArrayList<String> getOfficerPositions() {
        ArrayList<String> officerPositions = new ArrayList<>();
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");

            // Execute SQL query to retrieve officer positions
            PreparedStatement pstmt = conn.prepareStatement("SELECT DISTINCT position FROM officer ORDER BY position");
            ResultSet rst = pstmt.executeQuery();

            // Iterate through results and add to ArrayList
            while (rst.next()) {
                String position = rst.getString("position");
                officerPositions.add(position);
            }

            // Clean up resources
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            // Print error message
            System.out.println(e.getMessage());
        }

        return officerPositions;
    }
    
    public ArrayList<Integer> getOfficerHoids() {
    ArrayList<Integer> officerHoids = new ArrayList<>();
    try {
        // Establish database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
        System.out.println("Connection Successful");
        
        // Execute SQL query to retrieve distinct officer HOIDs
        PreparedStatement pstmt = conn.prepareStatement("SELECT DISTINCT ho_id FROM officer ORDER BY ho_id");
        ResultSet rst = pstmt.executeQuery();
        
        // Iterate through results and add to ArrayList
        while (rst.next()) {
            int officerHoid = rst.getInt("ho_id");
            officerHoids.add(officerHoid);
        }

        // Clean up resources
        pstmt.close();
        conn.close();

    } catch (SQLException e) {
        // Print error message
        System.out.println(e.getMessage());
    }

    return officerHoids;
    }   

    // Get a list of distinct positions from officer_presidents
    public ArrayList<String> getPresidentPositions() {
        ArrayList<String> positions = new ArrayList<>();

        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");

            // Execute SQL query to retrieve distinct positions
            PreparedStatement pstmt = conn.prepareStatement("SELECT DISTINCT position FROM officer_presidents ORDER BY position");
            ResultSet rst = pstmt.executeQuery();

            // Iterate through results and add to ArrayList
            while (rst.next()) {
                String position = rst.getString("position");
                positions.add(position);
            }

            // Clean up resources
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            // Print error message
            System.out.println(e.getMessage());
        }

        return positions;
    }

    // Get a list of distinct HO IDs from officer_presidents
    public ArrayList<Integer> getPresidentHoids() {
        ArrayList<Integer> hoids = new ArrayList<>();

        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");

            // Execute SQL query to retrieve distinct HO IDs
            PreparedStatement pstmt = conn.prepareStatement("SELECT DISTINCT ho_id FROM officer_presidents ORDER BY ho_id");
            ResultSet rst = pstmt.executeQuery();

            // Iterate through results and add to ArrayList
            while (rst.next()) {
                int hoid = rst.getInt("ho_id");
                hoids.add(hoid);
            }

            // Clean up resources
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            // Print error message
            System.out.println(e.getMessage());
        }

        return hoids;
    }

    public static void main (String args[]) {
        /*
        DonationManager donation = new DonationManager();
        donation.setDonorName("Ramon Magsaysay");
        donation.setDonationFormFile("mikh.pdf");
        donation.setDonationDate(new Date());
        donation.setAcceptHoid(9004);
        donation.setAcceptPosition("President");
        donation.setAcceptElectionDate(new Date(2022-1900, 11, 1));

        DonationManager donationManager = new DonationManager();
        donationManager.setDonation(donation);
        donationManager.record_donation();
        
        DonationManager donation2 = new DonationManager();
        donation2.setDonationId(6009);
        donation2.setDonorName("Ramon Magsaysay");
        donation2.setDonationFormFile("1stTimeUpdate.pdf");
        donation2.setDonationDate(new Date());
        donation2.setAcceptHoid(9004);
        donation2.setAcceptPosition("President");
        donation2.setAcceptElectionDate(new Date(2022-1900, 11, 1));

        DonationManager donationManager2 = new DonationManager();
        donationManager2.setDonation(donation2);
        donationManager2.update_donation();
        */
    }
}
