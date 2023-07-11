import os

import cv2
from reader import ImageReader
from Core import ImageCoparison


def main():
    ImageCoparison.ImageComparison.image_match(
        ImageReader.Reader.segmentationOneHundredPercent,
        ImageReader.Reader.segmentationExpected
    )


if __name__ == '__main__':
    main()
