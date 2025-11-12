import pandas as pd
import streamlit as st

import util.dbLayer as dbLayer

db = dbLayer.DbLayer()
index_logs = [[str(end - start), start, end, indexed] for [start, end, indexed] in
              db.get_indexed_tables_limit_10()]

df = pd.DataFrame(
    data=index_logs,
    columns=["Duration", "Started", "Ended", "Files Indexed"]
)

st.dataframe(df, hide_index=True)
