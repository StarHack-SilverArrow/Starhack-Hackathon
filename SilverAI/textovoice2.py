from azure.cognitiveservices.speech import AudioDataStream, SpeechConfig, SpeechSynthesizer, SpeechSynthesisOutputFormat
from azure.cognitiveservices.speech.audio import AudioOutputConfig

speech_config = SpeechConfig(subscription="ec74e4b931454c76951abaea33312e12", region="westeurope")

# Note: if only language is set, the default voice of that language is chosen.
speech_config.speech_synthesis_language = "en-US" # e.g. "de-DE"
# The voice setting will overwrite language setting.
# The voice setting will not overwrite the voice element in input SSML.
speech_config.speech_synthesis_voice_name ="en-US-AmberNeural"

audio_config = AudioOutputConfig(filename="D:\c#projects\GorselProgramlama\Starhack-Hackathon\SilverAI/file.wav")
synthesizer = SpeechSynthesizer(speech_config=speech_config, audio_config=audio_config)
synthesizer.speak_text_async("Welcome Emma")