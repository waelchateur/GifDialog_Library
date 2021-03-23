# GifDialog_Library 

A dialog library with GIF animation

## Forked from

[DialogAnimationLibrery](https://github.com/betojsc/DialogAnimationLibrery)

## Dependencies 

[android-gif-drawable](https://github.com/koral--/android-gif-drawable)

## GifDialog_Library Example

Dialog with two buttons Example :

``` java

new GifDialog.Builder(getActivity())
                .setTitle("They have a connection!! ")
                .setColorTitle(0xFF3F51B5)
                .setMessage("this is a message for everyone")
                .setMessageColor(0xFF3F51B5)
                .setPositiveBtnBackground(0xFF3F51B5)
                .setPositiveBtnText("Ok")
                 .setNegativeBtnBackground(0xFF3F51B5)
                .setNegativeBtnText("Cancel")
                .setGifResource(R.drawable.gif1)
                .setFont(typeface)
                .isCancellable(true)
                .OnPositiveClicked(() -> Toast.makeText(getActivity(), "Ok",
                        Toast.LENGTH_SHORT)
                        .show())
                .OnNegativeClicked(() -> Toast.makeText(getActivity(), "Cancel",
                        Toast.LENGTH_SHORT)
                        .show())
                .build();

```

Dialog with one button Example:

``` java

 new GifDialog.Builder(getActivity())
                .setTitle("They have a connection!! ")
                .setColorTitle(0xFF3F51B5)
                .setMessage("this is a message for everyone")
                .setMessageColor(0xFF3F51B5)
                .setPositiveBtnBackground(0xFF3F51B5)
                .setPositiveBtnText("Ok")
                .setGifResource(R.drawable.gif1)
                .setFont(typeface)
                .isCancellable(true)
                .OnPositiveClicked(() -> Toast.makeText(getActivity(), "Ok",
                        Toast.LENGTH_SHORT)
                        .show())
                .OnNegativeClicked(() -> Toast.makeText(getActivity(), "Cancel",
                        Toast.LENGTH_SHORT)
                        .show())
                .build();
```

## Basic usages

| Method | Description |
| :---- | :---- |
| setTitle(String) | The main title of the dialog |
| setColorTitle(int) | color text title |
| .setMessage(String) | dialog message |
| setMessageColor(int) | color text message |
| .setPositiveBtnText(String) | text of the positive button |
| .setPositiveBtnBackground(int) | positive button background color |
| .setNegativeBtnText(String) | text of the negative button |
| .setNegativeBtnBackground(int) | negative button background color |
| .setGifResource(Drawable) | gif image to use in the dialog |
| .setFont(Typeface) | font to use throughout the dialog |
| .isCancellable(boolean) | if it is canceled by the user when touching outside the dialog |
| .OnPositiveClicked(GifDialogListener()) | positive button action |
| .OnNegativeClicked(GifDialogListener()) | negative button action |

