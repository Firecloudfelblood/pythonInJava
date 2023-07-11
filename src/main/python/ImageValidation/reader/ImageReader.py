import cv2


class Reader:
    segmentationExpected = cv2.imread('src/main/python/ImageValidation/Images/segmentation20.png')
    segmentationOneHundredPercent = cv2.imread('src/main/python/ImageValidation/Images/segmentation100.png')