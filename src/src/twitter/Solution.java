package twitter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by vinitanilgaikwad on 10/15/16.
 */

/**
 * This class is used to store the input (Input is parsed from System.in at runtime)
 */
class InputDTO {
    Date currentDate;
    String engagementType;
    String numberOfEngagement;


    public InputDTO(Date currentDate, String engagementType, String numberOfEngagement) {
        this.currentDate = currentDate;
        this.engagementType = engagementType;
        this.numberOfEngagement = numberOfEngagement;
    }
}

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String interval = scan.nextLine();
        String[] intervalDuration = interval.replace(" ", "").replace("\n", "").split(",");


        SimpleDateFormat parserOne = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat parserTwo = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //Start Date from the Time Interval
            Date startDate = parserOne.parse(intervalDuration[0]);

            //End Date from the Time Interval
            Date endDate = parserOne.parse(intervalDuration[1]);


            // Map to track the Dates, which are already considered
            Map<Date, Integer> outPutMap = new HashMap<>();

            //Output
            List<String> aggregatedOutput = new ArrayList<>();

            Integer indexOfOutput = 0;
            scan.nextLine(); // Ignoring the empty line


            List<InputDTO> inputDTOList = new ArrayList<>();
            while (scan.hasNextLine()) {
                String currentLine = scan.nextLine();
                String[] partsOfCurrentLine = currentLine.replace(" ", "").split(",");
                if (partsOfCurrentLine.length != 3) break;
                Date currentDateWithoutDay = parserOne.parse(partsOfCurrentLine[0]);
                Date currentDateWithDay = parserTwo.parse(partsOfCurrentLine[0]);

                String engagementType = partsOfCurrentLine[1];
                String numberOfEngagement = partsOfCurrentLine[2];

                inputDTOList.add(new InputDTO(currentDateWithDay, engagementType, numberOfEngagement));

            }

            Collections.sort(inputDTOList, new Comparator<InputDTO>() {
                @Override
                public int compare(InputDTO o1, InputDTO o2) {
                    if (parserOne.format(o1.currentDate).equals(parserOne.format(o2.currentDate))) {
                        return o1.engagementType.compareTo(o2.engagementType);
                    } else {
                        return o2.currentDate.compareTo(o1.currentDate);
                    }
                }
            });

            for (InputDTO inputDTO : inputDTOList) {

                Date currentDateWithoutDay = parserOne.parse(parserOne.format(inputDTO.currentDate));
                Date currentDateWithDay = inputDTO.currentDate;

                String engagementType = inputDTO.engagementType;
                String numberOfEngagement = inputDTO.numberOfEngagement;

                if(Integer.parseInt(numberOfEngagement)>0 && engagementType !=null)
                if (currentDateWithDay.after(startDate) && currentDateWithDay.before(endDate)) {
                    if (outPutMap.get(currentDateWithoutDay) == null) {
                        aggregatedOutput.add(parserOne.format(currentDateWithoutDay) + ", " + engagementType + ", " + numberOfEngagement);
                        outPutMap.put(currentDateWithoutDay, aggregatedOutput.size() - 1);
                    } else {
                        indexOfOutput = outPutMap.get(currentDateWithoutDay);
                        String prevData = aggregatedOutput.get(indexOfOutput);
                        aggregatedOutput.set(indexOfOutput, updateEngagements(prevData, engagementType, numberOfEngagement));
                    }
                }

            }
            for (int i = 0; i < aggregatedOutput.size(); i++) {
                System.out.println(aggregatedOutput.get(i));
            }
        } catch (ParseException e) {
            throw e;
        }


        scan.close();
    }

    /**
     * Method To Update OutPut Line.
     * If Engagement Type is already considered, then update the value.
     * If Enganement type is not already considered, then append the engagement type and numberOfEngagement
     * @param prevData
     * @param engagementType
     * @param numberOfEngagement
     * @return
     */
    private static String updateEngagements(String prevData, String engagementType, String numberOfEngagement) {


        String[] partsOfPrevData = prevData.replace(" ", "").split(",");
        Boolean isEngagementTypeAlreadyPresent = Boolean.FALSE;

        for (int i = 0; i < partsOfPrevData.length; i++) {
            if (engagementType.equals(partsOfPrevData[i])) {
                partsOfPrevData[i + 1] = String.valueOf(Integer.valueOf(partsOfPrevData[i + 1]) + Integer.valueOf(numberOfEngagement));
                isEngagementTypeAlreadyPresent = Boolean.TRUE;
            }
        }
        StringBuilder resultantValue = new StringBuilder();
        resultantValue.append(partsOfPrevData[0]);
        for (int i = 1; i < partsOfPrevData.length; i++) {
            resultantValue.append(", ");
            resultantValue.append(partsOfPrevData[i]);

        }
        if(!isEngagementTypeAlreadyPresent){
            resultantValue.append(", ");
            resultantValue.append(engagementType);
            resultantValue.append(", ");
            resultantValue.append(numberOfEngagement);
        }
        return resultantValue.toString();
    }
}