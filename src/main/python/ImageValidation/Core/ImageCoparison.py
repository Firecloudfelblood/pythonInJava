import numpy as np
import cv2
from skimage.metrics import structural_similarity


class ImageComparison:

    def image_match(current, expected):
        if np.array_equal(expected, current):
            print('true')
        else:
            print('false')
            print(np.subtract(current, expected))

            expected_gray = cv2.cvtColor(expected, cv2.COLOR_BGR2GRAY)
            current_gray = cv2.cvtColor(current, cv2.COLOR_BGR2GRAY)

            (score, diff) = structural_similarity(expected_gray, current_gray, full=True)
            print('Image similarity: {:.4f}%'.format(score * 100))


